package fi.dy.masa.tweakeroo.config;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IConfigNotifiable;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.Tweakeroo;

public enum FeatureToggle implements IHotkeyTogglable, IConfigNotifiable<IConfigBoolean>
{
        TWEAK_ACCURATE_BLOCK_PLACEMENT  ("AccurateBlock | 精准方块放置",         false, "",    "启用类似Carpet模组的简化版灵活放置功能\n允许将方块朝向点击面的内部或外部放置"),
        TWEAK_AFTER_CLICKER             ("AfterClicker | 后置点击器",                   false, "",    KeybindSettings.INGAME_BOTH, "启用\"后置点击器（tweakAfterClicker）\"功能，\n自动对刚放置的方块执行右键操作。\n适用于快速设置中继器延迟等场景。\n按住功能切换键时滚动滚轮可快速调整数值。"),
        TWEAK_AIM_LOCK                  ("AimLock | 任意视线锁定",                        false, "",    "锁定当前视角的偏航角与俯仰角\n与精准视角锁定不同，此功能可自由锁定任意角度"),
        TWEAK_ANGEL_BLOCK               ("AngelBlock | 浮空放置方块",                     false, "",    "启用\"浮空放置方块（Angel Block）\"功能，\n允许在创造模式中空中放置方块。\n基于\"Flotato\"技术实现。"),
        TWEAK_BLOCK_REACH_OVERRIDE      ("BlockReachOverride | §6手长 - 方块触及距离修改§r",             false, "",    "修改原版方块触及距离为\n通用设置中的\"手长 - 方块触及距离修改（blockReachDistance）\""),
        TWEAK_BLOCK_TYPE_BREAK_RESTRICTION("BlockTypeBreak | 破坏限制 - 方块类型",    false, "",    "限制可破坏的方块类型\n具体配置见\"列表\"中的\"方块破坏限制（blockBreakRestriction）\""),
        TWEAK_BREAKING_GRID             ("BreakingGrid | 破坏限制 - 网格化",                   false, "",    KeybindSettings.INGAME_BOTH, "启用网格化限制破坏模式，按设定间隔破坏方块\n按住功能切换键时滚动鼠标可快速调整网格间隔"),
        TWEAK_BREAKING_RESTRICTION      ("BreakingRestriction | 破坏限制 - 范围",            false, "",    "启用破坏限制模式（平面/层状/点击面/列/十字/对角线）\n在按住攻击键时仅允许按指定模式破坏方块"),
        TWEAK_CHAT_BACKGROUND_COLOR     ("ChatBackgroundColor | 聊天背景色修改",            false, "",    "使用\"通用\"中的\"聊天背景色（chatBackgroundColor）\"值修改聊天背景色"),
        TWEAK_CHAT_PERSISTENT_TEXT      ("ChatPersistentText | 聊天文本持久化",             false, "",    "保存聊天输入框内容并在下次打开时自动恢复"),
        TWEAK_CHAT_TIMESTAMP            ("ChatTimestamp | 聊天时间戳",                  false, "",    "为聊天消息添加时间戳标记"),
        TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("CommandBlock | 命令方块扩展字段",        false, "",    "在命令方块界面添加额外字段\n可设置命令方块名称及查看统计结果"),
        TWEAK_CUSTOM_FLY_DECELERATION   ("flyDeceleration | 自定义飞行减速",          false, "",    "自定义创造/旁观模式的飞行减速参数\n主要用于实现更快的减速响应（减少滑行）\n详见\"通用\"中的\"自定义飞行减速（flyDeceleration）\""),
        TWEAK_CUSTOM_INVENTORY_GUI_SCALE("InventoryGui | 自定义背包界面缩放",     false, "",    "为所有容器界面使用自定义缩放比例\n缩放值见\"通用\"中的\"自定义背包界面缩放（customInventoryGuiScale）\""),
        TWEAK_ELYTRA_CAMERA             ("ElytraCamera | 鞘翅视角分离",                   false, "",    "启用鞘翅视角分离功能，按住激活键时锁定实际视角\n仅通过输入设备控制独立渲染视角\n专为鞘翅飞行时自由观察设计"),
        TWEAK_ENTITY_TYPE_ATTACK_RESTRICTION("EntityAttack | 实体类型攻击限制",false, "",    "限制可攻击的实体类型\n具体配置见\"列表\"中的\"实体攻击限制（EntityTypeAttackRestriction）\"相关项"),
        TWEAK_SHULKERBOX_STACKING       ("§6EmptyShulker | §6空潜影盒堆叠§r",         false, true, "",    "允许空潜影盒堆叠至64个\n§c警告：会导致服务器不同步问题（需服务端同步支持）\n§c单机模式将永久改变潜影盒系统行为"),
        TWEAK_SHULKERBOX_STACK_GROUND   ("§6EmptyS.B.Stack | §6空盒掉落物合并§r", false, true, "",    "Enables empty Shulker Boxes stacking up to 64\nwhen as items on the ground \n# 开启空潜影盒堆叠至 64 的功能，\n当它们作为地面物品时。"),
        TWEAK_EXPLOSION_REDUCED_PARTICLES ("ExplosionReduced | 爆炸粒子简化",    false, "",    "启用后，所有爆炸粒子将统一使用EXPLOSION_NORMAL粒子类型，\n而不采用EXPLOSION_LARGE或EXPLOSION_HUGE粒子变体。"),
        TWEAK_F3_CURSOR                 ("F3Cursor | F3光标显示",                       false, "",    "始终显示F3调试界面的光标坐标\n这仅适用于没有其他屏幕打开的情况；\n例如当你打开背包界面或设置时。"),
        TWEAK_FAKE_SNEAKING             ("FakeSneaking | 伪潜行",                   false, "",    "模拟潜行状态边缘防坠落\n不降低移动速度"),
        TWEAK_FAKE_SNEAK_PLACEMENT      ("FakeSneakPlacement | 伪潜行放置",             false, "",    "此调整将点击位置偏移至实际点击方块的相邻空气方块。\n这使你无需潜行即可在具有点击操作的方块（如打开物品栏GUI）旁放置方块。\n请注意这并非真正模拟潜行，只是视觉效果类似。"),
        TWEAK_FAST_BLOCK_PLACEMENT      ("FastBlockPlacement | 快速方块放置",             false, "",    "启用快速方块放置功能\n光标移动至新方块时自动快速放置"),
        TWEAK_FAST_LEFT_CLICK           ("FastLeftClick | 快速左键连点",                  false, "",    "启用自动左键连点功能\n连点频率见\"通用\""),
        TWEAK_FAST_RIGHT_CLICK          ("FastRightClick | 快速右键连点",                 false, "",    "启用自动右键连点功能\n连点频率见\"通用\""),
        TWEAK_FILL_CLONE_LIMIT          ("§6FillCloneLimit | §6fill clone 指令限制§r",                 false, true, "",    "在单机模式覆盖 fill 和 clone 命令的方块数量限制。\n限制值见\"通用\"中的\"fill clone 指令限制（fillCloneLimit）\"。"),
        TWEAK_FLY_SPEED                 ("FlySpeed | 飞行速度调节",                       false, "",    KeybindSettings.INGAME_BOTH, "覆盖创造/旁观模式的飞行速度\n支持使用预设方案"),
        TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("FlexibleBlock | 灵活方块放置",         false, "",    "启用灵活方块放置功能\n配合快捷键调整朝向与偏移位置"),
        TWEAK_FREE_CAMERA               ("FreeCamera | 灵魂出窍",                     false, "",    "启用类旁观模式的自由相机，\n玩家本体保持在激活位置，像是灵魂出窍了一样"),
        TWEAK_GAMMA_OVERRIDE            ("GammaOverride | 伽马值修改",                  false, "",    "使用\"通用\"中的值修改原版设置的伽马值"),
        TWEAK_HAND_RESTOCK              ("HandRestock | 自动补货",                    false, "",    "主/副手持物品耗尽时自动补充物品"),
        TWEAK_HANGABLE_ENTITY_BYPASS    ("HangableEntity | 悬挂实体绕过",           false, "",    "绕过悬挂实体（物品展示框/画）的交互限制\n通过\"通用\"中的\"悬挂实体绕过反转（hangableEntityBypassInverse）\"控制潜行状态条件"),
        TWEAK_HOLD_ATTACK               ("HoldAttack | 持续攻击",                     false, "",    "模拟持续按住攻击键状态"),
        TWEAK_HOLD_USE                  ("HoldUse | 持续使用",                        false, "",    "模拟持续按住使用键状态"),
        TWEAK_HOTBAR_SCROLL             ("HotbarScroll | 快捷栏滚动",                   false, "",    "启用通过滚轮切换快捷栏功能"),
        TWEAK_HOTBAR_SLOT_CYCLE         ("HotbarCycle | 快捷栏循环切换",                false, "",    KeybindSettings.INGAME_BOTH, "启用快捷栏循环切换功能\n放置方块后按设定最大槽位数循环\n按住功能切换键时滚动鼠标可调整参数"),
        TWEAK_HOTBAR_SLOT_RANDOMIZER    ("HotbarRandom | 快捷栏随机切换",           false, "",    KeybindSettings.INGAME_BOTH, "启用快捷栏随机切换功能\n放置方块后随机切换至设定最大槽位\n按住功能切换键时滚动鼠标可调整参数"),
        TWEAK_HOTBAR_SWAP               ("HotbarSwap | 快捷栏交换",                     false, "",    "启用快捷栏快捷键交换功能"),
        TWEAK_INVENTORY_PREVIEW         ("§6InventoryPreview | §6容器预览 - 开关§r",               false, true, "",    "将光标放在具有容器的方块或实体上并按住配置的快捷键时，启用容器预览。\n§6建议使用1.21+ MiniHUD版本替代"),
        TWEAK_ITEM_UNSTACKING_PROTECTION("ItemUnstacking | 物品溢出背包保护",       false, "",    "阻止\"列表\"中的\"溢出背包保护物品（unstackingItems）\"被丢弃扔出，\n即因使用动作时产生的新物品，但因为背包满了而被扔出。\n用于防止意外丢弃物品（如岩浆桶）。"),
        TWEAK_LAVA_VISIBILITY           ("LavaVisibility | 熔岩视野优化",                 false, "",    "水下呼吸和深海探索者附魔等级，\n以及火焰抗性效果的激活，\n将大大提高熔岩下的能见度。"),
        TWEAK_MAP_PREVIEW               ("MapPreview | 地图预览",                     false, "",    "悬停地图时按住Shift显示地图预览"),
        TWEAK_MOVEMENT_KEYS             ("MovementKeysLast | 末次移动按键优先",               false, "",    "启用末次按键优先机制\n相反方向移动键不会互相取消"),
        TWEAK_PERIODIC_ATTACK           ("PeriodicAttack | 周期性攻击",                 false, "",    "启用周期性攻击功能（左键点击）\n间隔时间配置：\"通用\"中的\"周期性攻击 - 间隔（periodicAttackInterval）\""),
        TWEAK_PERIODIC_USE              ("PeriodicUse | 周期性使用",                    false, "",    "启用周期性使用功能（右键点击）\n间隔时间配置：\"通用\"中的\"周期性使用 - 间隔（periodicUseInterval）\""),
        TWEAK_PERIODIC_HOLD_ATTACK      ("PeriodicHoldAttack | 周期性长按攻击",             false, "",    "启用可配置时长的周期性长按攻击键功能。\n\n间隔时间配置：\"通用\"中的\"周期性长按攻击 - 间隔（periodicHoldAttackInterval）\"\n持续时长配置：\"通用\"中的\"周期性长按攻击 - 时长（periodicHoldAttackDuration）\"\n\n§6注意：不应同时开启\"持续攻击（HoldAttack）\"§r\n§6和\"周期性攻击（PeriodicAttack）\"功能§r"),
        TWEAK_PERIODIC_HOLD_USE         ("PeriodicHoldUse | 周期性长按使用",                false, "",    "启用可配置时长的周期性按住使用键功能。\n\n间隔时间配置：\"通用\"中的\"周期性长按使用 - 间隔（periodicHoldUseInterval）\"\n持续时长配置：\"通用\"中的\"周期性长按使用 - 时长（periodicHoldUseDuration）\"\n\n§6注意：不应同时开启\"持续使用（HoldUse）\"§r\n§6和\"周期性使用（PeriodicUse）\"功能§r"),
        TWEAK_PERMANENT_SNEAK           ("PermanentSneak | 永久潜行",                 false, "",    "使玩家始终保持潜行状态"),
        TWEAK_PERMANENT_SPRINT          ("PermanentSprint | 永久疾跑",                false, "",    "使玩家前进时始终保持疾跑状态"),
        TWEAK_PICK_BEFORE_PLACE         ("PickBeforePlace | 放置前自动选材",                false, "",    "放置前自动切换与目标方块相同的物品"),
        TWEAK_PLACEMENT_GRID            ("PlacementGrid | 放置限制 - 网格化",                  false, "",    KeybindSettings.INGAME_BOTH, "启用网格化限制放置模式\n按住功能切换键时滚动鼠标可调整网格间隔"),
        TWEAK_PLACEMENT_LIMIT           ("PlacementLimit | 放置限制 - 单次数量",                 false, "",    KeybindSettings.INGAME_BOTH, "限制每次右键点击可放置的方块数量\n按住功能切换键时滚动鼠标可调整数量"),
        TWEAK_PLACEMENT_RESTRICTION     ("PlacementRestriction | 放置限制 - 范围",           false, "",    "启用放置限制模式（平面/层状/点击面/列/十字/对角线）"),
        TWEAK_PLACEMENT_REST_FIRST      ("PlacementRes.First | 放置限制 - 首次",      false, "",    "限制只能在与首次点击方块类型相同的方块旁放置"),
        TWEAK_PLACEMENT_REST_HAND       ("PlacementRes.Hand | 放置限制 - 手持物品",       false, "",    "限制只能放置与手持方块类型相同的方块"),
        TWEAK_PLAYER_INVENTORY_PEEK     ("PlayerInv.Peek | 玩家背包预览",            false, "",    "启用玩家背包预览功能\n需按住配置的快捷键激活"),
        TWEAK_POTION_WARNING            ("PotionWarning | 药水效果预警",                  false, "",    "当非环境类药水效果（如速度、力量等）剩余时间不足时，在快捷栏上方显示警告提示"),
        TWEAK_PRINT_DEATH_COORDINATES   ("PrintDeath | 死亡坐标打印",          false, "",    "死亡时在聊天栏输出坐标信息\n源自nessie的usefulmod模组"),
        TWEAK_PLAYER_LIST_ALWAYS_ON     ("PlayerList | 常显玩家列表",        false, "",    "无需按住Tab键即可常显玩家列表"),
        TWEAK_RENDER_EDGE_CHUNKS        ("RenderEdgeChunks | 边缘区块渲染",               false, "",    "允许渲染客户端加载的边缘区块\n原版会因相邻区块未加载而禁用边缘渲染\n§l此功能对\"灵魂出窍（Free Camera）\"模式非常有用！§r"),
        TWEAK_RENDER_INVISIBLE_ENTITIES ("RenderInvisible | 渲染隐形实体",        false, "",    "以旁观模式样式渲染隐形实体"),
        TWEAK_RENDER_LIMIT_ENTITIES     ("RenderLimitEntities | 实体渲染数量限制",            false, "",    "限制每帧渲染的特定实体数量\n当前支持经验球和物品实体\n详见「通用」中的限制参数"),
        TWEAK_REPAIR_MODE               ("RepairMode | 自动修复模式",                     false, "",    "自动将手持的完好物品\n替换为带有经验修补的受损物品"),
        TWEAK_SCULK_PULSE_LENGTH        ("§6SculkPulseLength | §6幽匿脉冲时长§r",               false, true, "",    "自定义幽匿感测体脉冲时长\n设置见\"通用\"中的\"幽匿感测体脉冲时长（sculkSensorPulseLength）\""),
        TWEAK_SHULKERBOX_DISPLAY        ("S.B.Display | 潜影盒内容显示",              false, "",    "按住Shift悬停潜影盒时显示内容物预览"),
        TWEAK_SIGN_COPY                 ("SignCopy | 告示牌文本复制",                       false, "",    "新放置的告示牌自动复制前次文本\n配合\"禁用 - 告示牌界面（disableSignGui）\"可快速批量复制告示牌"),
        TWEAK_SNAP_AIM                  ("SnapAim | 对齐视线",                        false, "",    KeybindSettings.INGAME_BOTH, "启用预设角度的精准视角锁定功能"),
        TWEAK_SNAP_AIM_LOCK             ("SnapAimLock | 对齐视线并锁定",                    false, "",    "将视角锁定至当前精准角度\n可单独锁定偏航角/俯仰角"),
        TWEAK_SNEAK_1_15_2              ("Sneak1.15.2 | 1.15.2潜行机制",                   false, "",    "还原1.15.2版本的潜行机制"),
        TWEAK_SPECTATOR_TELEPORT        ("SpectatorTeleport | 旁观者传送",              false, "",    "允许旁观者传送到其他旁观者玩家\n此功能源自nessie开发的usefulmod模组"),
        TWEAK_STRUCTURE_BLOCK_LIMIT     ("§6StructureLimit | §6结构方块限制§r",            false, true, "",    "允许覆盖结构方块的大小限制\n新限制值在\"通用\"中的\"结构方块最大尺寸（structureBlockMaxSize）\"中配置"),
        TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("SwapBrokenTools | 自动切换濒损工具",          false, "",    "当手持的耐久工具即将损坏时\n自动切换为完好的同类工具"),
        TWEAK_TAB_COMPLETE_COORDINATE   ("TabComplete | 坐标补全优化",          false, "",    "启用后，当未注视方块时进行坐标补全\n将直接使用玩家当前位置而非添加~符号"),
        TWEAK_TOOL_SWITCH               ("ToolSwitch | 自动切换工具",                     false, "",    "自动切换为适合破坏目标方块的有效工具"),
        TWEAK_WEAPON_SWITCH             ("WeaponSwitch | 自动切换武器",                   false, "",    "自动切换为适合攻击目标实体的有效武器"),
        TWEAK_Y_MIRROR                  ("YMirror | Y轴镜像放置(台阶、楼梯等)",                        false, "",    "在方块边界内镜像Y轴坐标进行放置\n主要用于台阶、楼梯类方块\n在相邻同类方块旁放置时反转顶部/底部状态"),
        TWEAK_ZOOM                      ("Zoom | 视角缩放",                           false, "",    KeybindSettings.INGAME_BOTH, "启用视角缩放快捷键功能");
        public static final ImmutableList<FeatureToggle> VALUES = ImmutableList.copyOf(values());

    private final String name;
    private final String comment;
    private final String prettyName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private boolean valueBoolean;
    private IValueChangeCallback<IConfigBoolean> callback;

    FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    FeatureToggle(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, settings, comment);
    }

    FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, settings, comment, StringUtils.splitCamelCase(name.substring(5)));
    }

    FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, false, defaultHotkey, comment, prettyName);
    }

    FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment, prettyName);
    }

    FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment, String prettyName)
    {
        this.name = name;
        this.valueBoolean = defaultValue;
        this.defaultValueBoolean = defaultValue;
        this.singlePlayer = singlePlayer;
        this.comment = comment;
        this.prettyName = prettyName;
        this.keybind = KeybindMulti.fromStorageString(defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));
    }

    @Override
    public ConfigType getType()
    {
        return ConfigType.HOTKEY;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getConfigGuiDisplayName()
    {
        String name = StringUtils.getTranslatedOrFallback("config.name." + this.getName().toLowerCase(), this.getName());

        if (this.singlePlayer)
        {
            return GuiBase.TXT_GOLD + name + GuiBase.TXT_RST;
        }

        return name;
    }

    @Override
    public String getPrettyName()
    {
        return this.prettyName;
    }

    @Override
    public String getStringValue()
    {
        return String.valueOf(this.valueBoolean);
    }

    @Override
    public String getDefaultStringValue()
    {
        return String.valueOf(this.defaultValueBoolean);
    }

    @Override
    public void setValueFromString(String value)
    {
    }

    @Override
    public void onValueChanged()
    {
        if (this.callback != null)
        {
            this.callback.onValueChanged(this);
        }
    }

    @Override
    public void setValueChangeCallback(IValueChangeCallback<IConfigBoolean> callback)
    {
        this.callback = callback;
    }

    @Override
    public String getComment()
    {
        String comment = StringUtils.getTranslatedOrFallback("config.comment." + this.getName().toLowerCase(), this.comment);

        if (comment != null && this.singlePlayer)
        {
            return comment + "\n" + StringUtils.translate("§6注意：在多人游戏中该功能可能不完全可用或完全不可用§r");
        }

        return comment;
    }

    @Override
    public IKeybind getKeybind()
    {
        return this.keybind;
    }

    @Override
    public boolean getBooleanValue()
    {
        return this.valueBoolean;
    }

    @Override
    public boolean getDefaultBooleanValue()
    {
        return this.defaultValueBoolean;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        boolean oldValue = this.valueBoolean;
        this.valueBoolean = value;

        if (oldValue != this.valueBoolean)
        {
            this.onValueChanged();
        }
    }

    @Override
    public boolean isModified()
    {
        return this.valueBoolean != this.defaultValueBoolean;
    }

    @Override
    public boolean isModified(String newValue)
    {
        return Boolean.parseBoolean(newValue) != this.defaultValueBoolean;
    }

    @Override
    public void resetToDefault()
    {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public JsonElement getAsJsonElement()
    {
        return new JsonPrimitive(this.valueBoolean);
    }

    @Override
    public void setValueFromJsonElement(JsonElement element)
    {
        try
        {
            if (element.isJsonPrimitive())
            {
                this.valueBoolean = element.getAsBoolean();
            }
            else
            {
                Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element);
            }
        }
        catch (Exception e)
        {
            Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element, e);
        }
    }
}