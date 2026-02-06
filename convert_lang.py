import re
import json
import os

def parse_java_configs(file_path):
    configs = []
    if not os.path.exists(file_path):
        print(f"Warning: File not found {file_path}")
        return configs
        
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Matches new Config...( "name", ... "comment" )
    # Note: capturing groups for name and comment
    regex_configs = r'new\s+Config[a-zA-Z0-9]+\s*\(\s*"([^"]+)"\s*,(?:[^)]*?)\s*"((?:[^"\\]|\\.)*)"\s*\)'
    
    for match in re.finditer(regex_configs, content, re.DOTALL):
        name = match.group(1)
        comment = match.group(2).replace('\n', '\n').replace('\\"', '"')
        configs.append({'name': name, 'comment': comment})
        
    if "FeatureToggle" in file_path:
        # regex for Enum("name", ... "comment")
        regex_enums = r'(?m)^\s*[A-Z0-9_]+\s*\(\s*"([^"]+)"\s*,(?:[^)]*?)\s*"((?:[^"\\]|\\.)*)"\s*\)'
        
        for match in re.finditer(regex_enums, content, re.DOTALL):
            name = match.group(1)
            comment = match.group(2).replace('\n', '\n').replace('\\"', '"')
            configs.append({'name': name, 'comment': comment})

    return configs

def parse_lang_file(file_path):
    lang_map = {}
    if not os.path.exists(file_path):
        print(f"Error: Lang file not found {file_path}")
        return lang_map
        
    with open(file_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()
        
    for i, line in enumerate(lines):
        line = line.strip()
        if not line or line.startswith('//'):
            continue
            
        if '=' in line:
            parts = line.split('=', 1)
            key = parts[0].strip()
            val = parts[1].strip()
            
            # The lang file uses literal \n sometimes
            val = val.replace('\n', '\n')
            
            lang_map[key] = val
            
    return lang_map

def normalize_text(text):
    # Remove all non-alphanumeric characters and lowercase
    # This helps match comments that differ only by punctuation
    return re.sub(r'[^a-zA-Z0-9]', '', text).lower()

def main():
    root_dir = r"c:\Users\qinsh\IdeaProjects\tweakeroo"
    files_to_scan = [
        os.path.join(root_dir, r"src\main\java\fi\dy\masa\tweakeroo\config\Configs.java"),
        os.path.join(root_dir, r"src\main\java\fi\dy\masa\tweakeroo\config\FeatureToggle.java")
    ]
    
    # Use the lang file in root as discovered
    lang_file = os.path.join(root_dir, "zh_cn.lang")
    json_file = os.path.join(root_dir, r"src\main\resources\assets\tweakeroo\lang\zh_cn.json")
    
    configs = []
    for p in files_to_scan:
        cfgs = parse_java_configs(p)
        print(f"Scanned {os.path.basename(p)}: found {len(cfgs)} configs")
        configs.extend(cfgs)
    
    lang_map = parse_lang_file(lang_file)
    print(f"Scanned lang file: found {len(lang_map)} entries")
    
    # Create normalized map for comments
    # key: normalized English text, value: Chinese translation
    normalized_lang_map = {}
    for k, v in lang_map.items():
        norm_k = normalize_text(k)
        if norm_k:
            normalized_lang_map[norm_k] = v
            
    # Load existing JSON
    if os.path.exists(json_file):
        with open(json_file, 'r', encoding='utf-8') as f:
            json_text = f.read()

        # Simple comment stripping because standard json lib doesn't support comments
        sanitized_lines = []
        for line in json_text.splitlines():
            # Remove comments starting with // but keep http://
            # Very naive, but sufficient for standard json
            if '//' in line and "http" not in line:
                 line = line.split('//')[0]
            sanitized_lines.append(line)
        
        try:
            data = json.loads('\n'.join(sanitized_lines))
        except Exception as e:
            print(f"Error loading JSON: {e}")
            data = {}
    else:
        data = {}

    count_names = 0
    count_comments = 0
    
    for cfg in configs:
        name = cfg['name']
        comment = cfg['comment']
        lower_name = name.lower()
        
        # 1. Update Config Name
        if name in lang_map:
            key_id = f"config.name.{lower_name}"
            data[key_id] = lang_map[name]
            count_names += 1
        
        # 2. Update Config Comment
        # Try exact match first
        if comment in lang_map:
             key_id = f"config.comment.{lower_name}"
             data[key_id] = lang_map[comment]
             count_comments += 1
        else:
            # Try normalized match
            norm_comment = normalize_text(comment)
            if norm_comment in normalized_lang_map:
                key_id = f"config.comment.{lower_name}"
                data[key_id] = normalized_lang_map[norm_comment]
                count_comments += 1
            
    print(f"Successfully mapped {count_names} names and {count_comments} comments.")
    
    with open(json_file, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=4, ensure_ascii=False)

if __name__ == "__main__":
    main()
