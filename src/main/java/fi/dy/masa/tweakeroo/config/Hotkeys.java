package fi.dy.masa.tweakeroo.config;

import java.util.List;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.hotkeys.KeybindSettings.Context;

public class Hotkeys
{
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_IN        = new ConfigHotkey("accurateInto | 精准放置模式",        "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活精确放置的快捷键，使用后方块将放置于点击的块面上");
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_REVERSE   = new ConfigHotkey("accurateReverse | 精准放置（反向）",     "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活精确放置的快捷键，使用后方块将反向放置于点击的块面上");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_COLUMN   = new ConfigHotkey("breaking | 破坏范围限制 直线",     "",     "将破坏范围限制在 当前直线。");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_DIAGONAL = new ConfigHotkey("breaking | 破坏范围限制 对角线",   "",     "将破坏范围限制在 对角线。");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_FACE     = new ConfigHotkey("breaking | 破坏范围限制 面朝",       "",     "将破坏范围限制在 面朝方向。");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LAYER    = new ConfigHotkey("breaking | 破坏范围限制 水平面",      "",     "将破坏范围限制在 同水平面上。");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LINE     = new ConfigHotkey("breaking | 破坏范围限制 棱边",       "",     "将破坏范围限制在  放置方块的棱边上。");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_PLANE    = new ConfigHotkey("breaking | 破坏范围限制 平面",      "",     "将破坏范围限制在 同平面上。");
    public static final ConfigHotkey COPY_SIGN_TEXT                     = new ConfigHotkey("copySignText | 告示牌文本复制",                      "",     "开启后上一个告示牌中输入的文本将作为初始值输入至下一个告示牌。");
    public static final ConfigHotkey ELYTRA_CAMERA                      = new ConfigHotkey("elytraCamera | 环顾四周",                      "",     "按住此快捷键会锁定玩家当前的视角方向，\n使玩家鼠标输入仅改变摄像机视角而不改变移动方向。 \n应用此功能需要开启§6[工具开关]-[环顾四周]§f");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ADJACENT  = new ConfigHotkey("flexible | 方块灵活放置（相邻）",    "",     KeybindSettings.PRESS_ALLOWEXTRA, "按下以激活灵活放置模式，按下该按键时可将方块放置在当前方块的 相邻 的位置。");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_OFFSET    = new ConfigHotkey("flexible | 方块灵活放置（棱角）",      "LEFT_CONTROL", KeybindSettings.PRESS_ALLOWEXTRA, "按下以激活灵活放置模式，按下该按键时可将方块放置在当前方块的 斜角或隔空 的位置。");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ROTATION  = new ConfigHotkey("flexible | 方块灵活放置（旋转）",    "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "按下以激活灵活放置模式，按下该按键时可将方块以选定的方向放置。 \n注：要使此项功能能够正常使用，\n通常需要在服务器开启§6Carpet§f的§e精确放置协议§f的环境下\n同时启用§6Tweakeroo§f的§e地毯精确放置协议§f功能。");
    public static final ConfigHotkey FLY_PRESET_1                       = new ConfigHotkey("flyPreset1 | 飞行预设1",                        "",     "按下此快捷键以切换至飞行速度预设1");
    public static final ConfigHotkey FLY_PRESET_2                       = new ConfigHotkey("flyPreset2 | 飞行预设2",                        "",     "切换至飞行预设2");
    public static final ConfigHotkey FLY_PRESET_3                       = new ConfigHotkey("flyPreset3 | 飞行预设3",                        "",     "切换至飞行预设3");
    public static final ConfigHotkey FLY_PRESET_4                       = new ConfigHotkey("flyPreset4 | 飞行预设4",                        "",     "切换至飞行预设4");
    public static final ConfigHotkey FREE_CAMERA_PLAYER_INPUTS          = new ConfigHotkey("freeCam | 灵魂出窍玩家操作",            "",     "用于切换[通用设置]-[灵魂出窍玩家操作]功能的开启与关闭。");
    public static final ConfigHotkey FREE_CAMERA_PLAYER_MOVEMENT        = new ConfigHotkey("freeCamPlayer | 灵魂/身体操作切换",          "",     "切换通用功能中的\\freeCamPlayer | 灵魂/身体操作切换\\选项");
    public static final ConfigHotkey HOTBAR_SCROLL                      = new ConfigHotkey("hotbarScroll | 物品栏循环使用",                      "",     KeybindSettings.RELEASE_ALLOW_EXTRA, "使用快捷键切换功能开关。 \n启用该选项会在玩家每次使用完物品后自动切换至物品栏下一物品，\n切换范围可在§6[通用功能]-[物品栏循环最大值]§f中设置。");
    public static final ConfigHotkey HOTBAR_SWAP_BASE                   = new ConfigHotkey("hotbarSwapBase | 显示背包内容物",                    "",     KeybindSettings.PRESS_ALLOWEXTRA, "按下快捷键时，将显示背包内容物。 \n显示位置可在§6[通用功能]-[背包显示位置]§f处更改");
    public static final ConfigHotkey HOTBAR_SWAP_1                      = new ConfigHotkey("hotbarSwap1 | 顶层快捷切换",                       "",     "按下快捷键时，将物品栏与背包顶层一行交换");
    public static final ConfigHotkey HOTBAR_SWAP_2                      = new ConfigHotkey("hotbarSwap2 | 中层快捷切换",                       "",     "按下快捷键时，将物品栏与背包中层一行交换");
    public static final ConfigHotkey HOTBAR_SWAP_3                      = new ConfigHotkey("hotbarSwap3 | 底层快捷切换",                       "",     "按下快捷键时，将物品栏与背包底层一行交换");
    public static final ConfigHotkey INVENTORY_PREVIEW                  = new ConfigHotkey("§6inventoryPreview | 容器预览§f",                  "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "按下快捷键时，可预览容器内的物品。 \n§6此项通常仅在单人时生效。§f");
    public static final ConfigHotkey OPEN_CONFIG_GUI                    = new ConfigHotkey("openConfigGui | 打开配置界面",                     "X,C",  "打开§6Tweakeroo§f配置界面的快捷键。");
    public static final ConfigHotkey PLACEMENT_Y_MIRROR                 = new ConfigHotkey("placementYMirror | Y轴镜像放置",                  "",     KeybindSettings.PRESS_ALLOWEXTRA, "按下快捷键时，将方块以Y轴镜像的方式放置出来。\n需要开启§6[工具开关]-[Y轴镜像放置]§f。");
    public static final ConfigHotkey PLAYER_INVENTORY_PEEK              = new ConfigHotkey("§6InventoryPeek | 玩家背包预览§f",               "",     KeybindSettings.PRESS_ALLOWEXTRA, "按下快捷键时，可预览准心指向的玩家的背包。 \n§6此项通常仅在单人时生效。§f");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_COLUMN  = new ConfigHotkey("fastPlacement | 方块放置限制 直线",    "Z,3",  "将快速放置的方块放置范围限制在 当前直线。");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_DIAGONAL= new ConfigHotkey("fastPlacement | 方块放置限制 对角线",  "Z,5",  "将快速放置的方块放置范围限制在 对角线 \n§6注意：此功能无法凭空放置方块。§f");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_FACE    = new ConfigHotkey("fastPlacement | 方块放置限制 面朝",      "Z,2",  "将快速放置的方块放置范围限制在 面朝方向。");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LAYER   = new ConfigHotkey("fastPlacement | 方块放置限制 水平面",     "Z,6",  "将快速放置的方块放置范围限制在 同水平面上。");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LINE    = new ConfigHotkey("fastPlacement | 方块放置限制 棱边",      "Z,4",  "将快速放置的方块放置范围限制在 放置方块的棱边上。");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_PLANE   = new ConfigHotkey("fastPlacement | 方块放置限制 平面",     "Z,1",  "将快速放置的方块放置范围限制在 同平面上。");
    public static final ConfigHotkey SIT_DOWN_NEARBY_PETS               = new ConfigHotkey("sitDown | 坐下！",                 "",     "让附近所有的宠物坐下");
    public static final ConfigHotkey SKIP_ALL_RENDERING                 = new ConfigHotkey("skipAllRender | 跳过全部渲染",                  "",     "使用快捷键切换开启/关闭。 \n开启此项后，所有的渲染运算都会被跳过。");
    public static final ConfigHotkey SKIP_WORLD_RENDERING               = new ConfigHotkey("skipWorldRender | 跳过世界渲染",                "",     "使用快捷键切换开启/关闭。 \n开启此项后，所有关于世界的渲染运算都会被跳过。");
    public static final ConfigHotkey STAND_UP_NEARBY_PETS               = new ConfigHotkey("standUp | 起来！",                 "",     "让附近所有的宠物站起//全体起立！我向周围的猫猫狗狗宣布！\n从今天起这个地方叫lbw广场！\nby-yuki");
    public static final ConfigHotkey SWAP_ELYTRA_CHESTPLATE             = new ConfigHotkey("swapElytra | 鞘翅胸甲",              "",     "按下快捷键时，更换胸部装备为鞘翅/胸甲。");
    public static final ConfigHotkey TOGGLE_CARPET_AP_PROTOCOL          = new ConfigHotkey("toggleCarpet | 切换地毯精确放置协议", "", "开关通用中的地毯精确放置协议");
    public static final ConfigHotkey TOGGLE_GRAB_CURSOR                 = new ConfigHotkey("toggleGrabCursor | 切换鼠标",                  "",     "将鼠标从当前窗口切换到外部窗口，在外部窗口的鼠标操作不影响游戏内操作。");
    public static final ConfigHotkey TOOL_PICK                          = new ConfigHotkey("toolPick | 自动选择工具",                          "",     "按下快捷键后切换到适合采集当前方块的工具。");
    public static final ConfigHotkey WRITE_MAPS_AS_IMAGES               = new ConfigHotkey("writeMaps | 地图导出",                 "",     "将所有当前可用的地图作为图像写入到 \n'config/tweakeroo/map images/<world name>/' 目录");
    public static final ConfigHotkey ZOOM_ACTIVATE                      = new ConfigHotkey("zoomActivate | 激活望远镜",                      "",     KeybindSettings.create(Context.INGAME, KeyAction.BOTH, true, false, false, false, false), "望远镜激活热键。");

    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            ACCURATE_BLOCK_PLACEMENT_IN,
            ACCURATE_BLOCK_PLACEMENT_REVERSE,
            BREAKING_RESTRICTION_MODE_COLUMN,
            BREAKING_RESTRICTION_MODE_DIAGONAL,
            BREAKING_RESTRICTION_MODE_FACE,
            BREAKING_RESTRICTION_MODE_LAYER,
            BREAKING_RESTRICTION_MODE_LINE,
            BREAKING_RESTRICTION_MODE_PLANE,
            COPY_SIGN_TEXT,
            ELYTRA_CAMERA,
            FLEXIBLE_BLOCK_PLACEMENT_ADJACENT,
            FLEXIBLE_BLOCK_PLACEMENT_OFFSET,
            FLEXIBLE_BLOCK_PLACEMENT_ROTATION,
            FLY_PRESET_1,
            FLY_PRESET_2,
            FLY_PRESET_3,
            FLY_PRESET_4,
            FREE_CAMERA_PLAYER_INPUTS,
            FREE_CAMERA_PLAYER_MOVEMENT,
            HOTBAR_SCROLL,
            HOTBAR_SWAP_BASE,
            HOTBAR_SWAP_1,
            HOTBAR_SWAP_2,
            HOTBAR_SWAP_3,
            INVENTORY_PREVIEW,
            OPEN_CONFIG_GUI,
            PLACEMENT_Y_MIRROR,
            PLAYER_INVENTORY_PEEK,
            PLACEMENT_RESTRICTION_MODE_COLUMN,
            PLACEMENT_RESTRICTION_MODE_DIAGONAL,
            PLACEMENT_RESTRICTION_MODE_FACE,
            PLACEMENT_RESTRICTION_MODE_LAYER,
            PLACEMENT_RESTRICTION_MODE_LINE,
            PLACEMENT_RESTRICTION_MODE_PLANE,
            SIT_DOWN_NEARBY_PETS,
            SKIP_ALL_RENDERING,
            SKIP_WORLD_RENDERING,
            STAND_UP_NEARBY_PETS,
            SWAP_ELYTRA_CHESTPLATE,
            TOGGLE_CARPET_AP_PROTOCOL,
            TOGGLE_GRAB_CURSOR,
            TOOL_PICK,
            WRITE_MAPS_AS_IMAGES,
            ZOOM_ACTIVATE
    );
}
