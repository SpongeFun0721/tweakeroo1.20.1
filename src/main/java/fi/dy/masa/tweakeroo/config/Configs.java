package fi.dy.masa.tweakeroo.config;

import java.io.File;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.MinecraftClient;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.HudAlignment;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.config.options.ConfigStringList;
import fi.dy.masa.malilib.util.ActiveMode;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import fi.dy.masa.malilib.util.MessageOutputType;
import fi.dy.masa.malilib.util.restrictions.UsageRestriction.ListType;
import fi.dy.masa.tweakeroo.Reference;
import fi.dy.masa.tweakeroo.tweaks.MiscTweaks;
import fi.dy.masa.tweakeroo.tweaks.PlacementTweaks;
import fi.dy.masa.tweakeroo.util.InventoryUtils;
import fi.dy.masa.tweakeroo.util.PlacementRestrictionMode;
import fi.dy.masa.tweakeroo.util.SnapAimMode;

public class Configs implements IConfigHandler
{
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic
    {
    public static final ConfigInteger       AFTER_CLICKER_CLICK_COUNT           = new ConfigInteger     ("afterClicker | 放置后点击次数",  1, 1, 32, "当放置方块后，右键点击的次数。");
    public static final ConfigDouble        BLOCK_REACH_DISTANCE                = new ConfigDouble      ("blockReach | 方块放置距离", 4.5, 0, 8, "更改你的手长，让你能够放置\\\\破坏更远的方块。\n服务器最多允许的距离为：八格放置与六格破坏\n §4注意：该功能不属于原版+TAS可实现或公平的功能，而且有很大的作弊争议。§f\n§4使用此功能前请询问服务器管理是否允许此功能使用。§f");
    public static final ConfigOptionList    BLOCK_TYPE_BREAK_RESTRICTION_WARN   = new ConfigOptionList  ("blockBreakWarn | 方块破坏限制 - 警告提示位置", MessageOutputType.MESSAGE, "当方块类型破坏限制功能阻止破坏方块时，选择显示的警告类型（若有）");
    public static final ConfigInteger       BREAKING_GRID_SIZE                  = new ConfigInteger     ("breaking | 破坏限制 - 网格尺寸", 3, 1, 1000, "网格破坏模式的网格间隔尺寸。\n按住功能切换键时滚动可快速调整此值。");
    public static final ConfigOptionList    BREAKING_RESTRICTION_MODE           = new ConfigOptionList  ("breaking | 破坏限制 - 模式", PlacementRestrictionMode.LINE, "使用的破坏限制模式（可通过快捷键选择）");
    public static final ConfigColor         CHAT_BACKGROUND_COLOR               = new ConfigColor       ("chatBack | 聊天背景色", "#80000000", "启用“聊天背景色修改（tweakChatBackgroundColor）”时聊天信息的背景颜色");
    public static final ConfigString        CHAT_TIME_FORMAT                    = new ConfigString      ("chatTime | 聊天时间格式", "[HH:mm:ss]", "启用聊天时间戳时的日期格式，\n使用Java SimpleDateFormat格式规范。");
    public static final ConfigBoolean       CARPET_ACCURATE_PLACEMENT_PROTOCOL  = new ConfigBoolean     ("carpetAccurate | 精准放置协议 - 开关", true, "启用后，灵活方块放置和精准方块放置将使用Carpet模组实现的协议。\n§6注意：此功能是实现除点击面相关方块（漏斗、原木等）外，\n§6其他方块的旋转功能所必需的。");
    public static final ConfigBoolean       CLIENT_PLACEMENT_ROTATION           = new ConfigBoolean     ("clientPlacement | 客户端放置旋转", true, "在单人游戏或客户端启用放置旋转功能\n（例如无需Carpet模组即可在单人游戏中使用精准放置）");
    public static final ConfigInteger       CUSTOM_INVENTORY_GUI_SCALE          = new ConfigInteger     ("InventoryGui | 自定义背包界面缩放", 2, 1, 10, "启用§e\"自定义背包界面缩放（tweakCustomInventoryScreenScale）\"§r时，\n背包界面的缩放值。");
    public static final ConfigOptionList    ELYTRA_CAMERA_INDICATOR             = new ConfigOptionList  ("elytraCamera | 鞘翅视角指示器", ActiveMode.WITH_KEY, "鞘翅视角模式激活时是否显示真实俯仰角指示器");
    public static final ConfigOptionList    ENTITY_TYPE_ATTACK_RESTRICTION_WARN = new ConfigOptionList  ("entityAttackWarn | 实体攻击限制 - 警告提示位置", MessageOutputType.MESSAGE, "当实体类型攻击限制功能阻止攻击实体时，\n选择显示的警告类型（若有）");
    public static final ConfigInteger       FAST_BLOCK_PLACEMENT_COUNT          = new ConfigInteger     ("fastBlock | 快速方块放置数量", 2, 1, 16, "快速方块放置功能每游戏刻可放置的最大方块数");
    public static final ConfigBoolean       FAST_LEFT_CLICK_ALLOW_TOOLS         = new ConfigBoolean     ("LeftClickTools | 快速左键允许工具", false, "允许生存模式下持工具时使用快速左键功能。\n§6这会让玩家可以每tick破坏多个方块");
    public static final ConfigInteger       FAST_LEFT_CLICK_COUNT               = new ConfigInteger     ("fastLeft | 快速左键点击次数",  10, 1, 64, "启用快速左键且按住攻击键时，每游戏刻的左键点击次数");
    public static final ConfigBoolean       FAST_PLACEMENT_REMEMBER_ALWAYS      = new ConfigBoolean     ("fastPlacement | 快速放置记忆朝向", true, "启用后，快速方块放置将始终记忆首个放置方块的朝向。\n未启用时，仅当灵活放置功能激活时才会记忆朝向。");
    public static final ConfigInteger       FAST_RIGHT_CLICK_COUNT              = new ConfigInteger     ("fastRight | 快速右键点击次数", 10, 1, 64, "启用快速右键且按住使用键时，每游戏刻的右键点击次数");
    public static final ConfigInteger       FILL_CLONE_LIMIT                    = new ConfigInteger     ("fillClone | fill clone 指令上限", 10000000, 1, 1000000000, "启用此功能时，\n单人游戏中\"/fill\"和\"/clone\"指令的操作方块上限");
    public static final ConfigColor         FLEXIBLE_PLACEMENT_OVERLAY_COLOR    = new ConfigColor       ("flexibleBlock | 灵活放置高亮颜色", "#C03030F0", "灵活放置功能中当前指向区域的高亮颜色");
    public static final ConfigDouble        FLY_DECELERATION_FACTOR             = new ConfigDouble      ("flyDeceleration | 飞行减速系数", 0.4, 0.0, 1.0, "调整\"自定义飞行减速（customFlyDeceleration）\"\n功能启用时的玩家减速速率");
    public static final ConfigDouble        FLY_SPEED_PRESET_1                  = new ConfigDouble      ("flySpeed | 飞行速度 - 预设1", 0.01, 0, 4, "预设1的飞行速度");
    public static final ConfigDouble        FLY_SPEED_PRESET_2                  = new ConfigDouble      ("flySpeed | 飞行速度 - 预设2", 0.064, 0, 4, "预设2的飞行速度");
    public static final ConfigDouble        FLY_SPEED_PRESET_3                  = new ConfigDouble      ("flySpeed | 飞行速度 - 预设3", 0.128, 0, 4, "预设3的飞行速度");
    public static final ConfigDouble        FLY_SPEED_PRESET_4                  = new ConfigDouble      ("flySpeed | 飞行速度 - 预设4", 0.32, 0, 4, "预设4的飞行速度");
    public static final ConfigBoolean       FREE_CAMERA_PLAYER_INPUTS           = new ConfigBoolean     ("freeCam | 灵魂出窍 - 玩家左右键", false, "启用后，灵魂出窍模式中的\n攻击和使用动作（即左右键）将传递给实际玩家角色。");
    public static final ConfigBoolean       FREE_CAMERA_PLAYER_MOVEMENT         = new ConfigBoolean     ("freeCamPlayer | 灵魂出窍 - 本体移动", false, "开启此功能后，§6灵魂出窍§f的开关会与§6灵魂/身体操作切换§f的开关绑定在一起。\n也就是说，你每次开启灵魂出窍后会默认操控身体而不是视角。");
    public static final ConfigDouble        GAMMA_OVERRIDE_VALUE                = new ConfigDouble      ("gammaOverride | 伽马覆盖值", 16, 0, 32, "启用伽马覆盖时使用的亮度值");
    public static final ConfigBoolean       HAND_RESTOCK_PRE                    = new ConfigBoolean     ("handRestockPre | 自动补货 - 预先补货", true, "开启后，手里的物品将在耗尽前预先自动补货");
    public static final ConfigInteger       HAND_RESTOCK_PRE_THRESHOLD          = new ConfigInteger     ("handRestock | 自动补货 - 预先补货阈值", 6, 1, 64, "预先补货模式下自动补货触发的数量阈值");
    public static final ConfigBoolean       HANGABLE_ENTITY_BYPASS_INVERSE      = new ConfigBoolean     ("hangableEntity | 悬挂实体绕过反转", false, "若启用悬挂实体目标绕过功能，此选项控制玩家是否需要潜行\n才能选中悬挂实体（物品展示框或画作）。\n > true - 潜行时忽略实体\n > false - 潜行时选中实体");
    public static final ConfigInteger       HOTBAR_SLOT_CYCLE_MAX               = new ConfigInteger     ("hotbarSlot | 快捷栏循环上限", 2, 1, 9, "快捷栏循环功能使用的最后一个槽位编号。\n当超过此处设置的最大值时，循环将跳回第一个槽位。");
    public static final ConfigInteger       HOTBAR_SLOT_RANDOMIZER_MAX          = new ConfigInteger     ("hotbarSlot | 快捷栏随机上限", 5, 1, 9, "快捷栏随机功能使用的最大槽位编号。\n每次使用物品后，将随机选择1至此最大值之间的槽位。");
    public static final ConfigOptionList    HOTBAR_SWAP_OVERLAY_ALIGNMENT       = new ConfigOptionList  ("hotbarSwap | 快捷栏切换界面对齐", HudAlignment.BOTTOM_RIGHT, "快捷栏切换界面的对齐方式");
    public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_X        = new ConfigInteger     ("hotbarSwap | 快捷栏切换界面X偏移", 4, "快捷栏切换界面的水平偏移量");
    public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_Y        = new ConfigInteger     ("hotbarSwap | 快捷栏切换界面Y偏移", 4, "快捷栏切换界面的垂直偏移量");
    public static final ConfigInteger       ITEM_SWAP_DURABILITY_THRESHOLD      = new ConfigInteger     ("itemSwap | 物品交换耐久阈值", 20, 5, 10000, "低耐久物品交换功能的耐久阈值（剩余使用次数）。\n注意：总耐久较低的物品会在剩余5%%时被交换。");
    public static final ConfigBoolean       ITEM_USE_PACKET_CHECK_BYPASS        = new ConfigBoolean     ("itemUse | 物品使用数据包检查绕过", true, "绕过1.18.2新增的距离/坐标检查。\n\n该检查会破坏精准放置协议并导致\n任何带有旋转（或其他属性）请求的放置方块变为幽灵方块。\n\n基本无需禁用此功能。\n该检查在1.18.2之前从未存在。");
    public static final ConfigInteger       MAP_PREVIEW_SIZE                    = new ConfigInteger     ("mapPreviewSize | 地图预览尺寸", 160, 16, 512, "渲染地图预览的尺寸");
    public static final ConfigInteger       PERIODIC_ATTACK_INTERVAL            = new ConfigInteger     ("periodicAttack | 周期性攻击 - 间隔", 20, 0, Integer.MAX_VALUE, "自动攻击（左键）间隔的游戏刻数");
    public static final ConfigInteger       PERIODIC_USE_INTERVAL               = new ConfigInteger     ("periodicUse | 周期性使用 - 间隔", 20, 0, Integer.MAX_VALUE, "自动使用（右键）间隔的游戏刻数");
    public static final ConfigInteger       PERIODIC_HOLD_ATTACK_DURATION       = new ConfigInteger     ("periodicHoldAttack | 周期性长按攻击 - 时长", 20, 0, Integer.MAX_VALUE, "持续按住攻击键的游戏刻时长");
    public static final ConfigInteger       PERIODIC_HOLD_ATTACK_INTERVAL       = new ConfigInteger     ("periodicHoldAttack | 周期性长按攻击 - 间隔", 20, 0, Integer.MAX_VALUE, "开始持续攻击（左键）的间隔游戏刻数");
    public static final ConfigInteger       PERIODIC_HOLD_USE_DURATION          = new ConfigInteger     ("periodicHoldAttack | 周期性长按使用 - 时长", 20, 0, Integer.MAX_VALUE, "持续按住使用键的游戏刻时长");
    public static final ConfigInteger       PERIODIC_HOLD_USE_INTERVAL          = new ConfigInteger     ("periodicHoldAttack | 周期性长按使用 - 间隔", 20, 0, Integer.MAX_VALUE, "开始持续使用（右键）的间隔游戏刻数");
    public static final ConfigBoolean       PERMANENT_SNEAK_ALLOW_IN_GUIS       = new ConfigBoolean     ("permanentSneak | 永久潜行在打开GUI界面时依然有效", false, "打开GUI界面时，永久潜行依然有效");
    public static final ConfigInteger       PLACEMENT_GRID_SIZE                 = new ConfigInteger     ("placementGridSize | 放置网格尺寸", 3, 1, 1000, "网格放置模式的网格间隔尺寸。\n按住功能切换键时滚动可快速调整此值。");
    public static final ConfigInteger       PLACEMENT_LIMIT                     = new ConfigInteger     ("placementLimit | 放置数量限制", 3, 1, 10000, "启用\"放置限制 - 单次数量（tweakPlacementLimit）\"时，\n每次右键单击最多可放置的方块数。\n按住功能切换键时滚动可快速调整此值。");
    public static final ConfigOptionList    PLACEMENT_RESTRICTION_MODE          = new ConfigOptionList  ("placement | 放置限制模式", PlacementRestrictionMode.FACE, "使用的放置限制模式（可通过快捷键选择）");
    public static final ConfigBoolean       PLACEMENT_RESTRICTION_TIED_TO_FAST  = new ConfigBoolean     ("placement | 放置限制与快速模式联动", true, "启用时，放置限制模式将随快速放置模式的切换而改变其启用/禁用状态。");
    public static final ConfigBoolean       POTION_WARNING_BENEFICIAL_ONLY      = new ConfigBoolean     ("potion | 仅警告有益药水", true, "仅对标记为'有益'的药水效果显示即将结束的警告");
    public static final ConfigInteger       POTION_WARNING_THRESHOLD            = new ConfigInteger     ("potionWarning | 药水警告阈值", 600, 1, 1000000, "触发药水效果警告的剩余时长（游戏刻）");
    public static final ConfigBoolean       REMEMBER_FLEXIBLE                   = new ConfigBoolean     ("rememberFlexible | 记忆灵活放置初始点击", true, "启用后，只要按住使用键（右键），\n灵活放置状态将从首个放置方块开始保持。\n无需持续按住所有灵活功能激活键即可快速放置同朝向方块。");
    public static final ConfigInteger       RENDER_LIMIT_ITEM                   = new ConfigInteger     ("renderLimitItem | 物品渲染数量上限", -1, -1, 10000, "每帧渲染的物品实体最大数量。\n-1为默认值（禁用此限制）。");
    public static final ConfigInteger       RENDER_LIMIT_XP_ORB                 = new ConfigInteger     ("renderLimitXPOrb | 经验球渲染数量上限", -1, -1, 10000, "每帧渲染的经验球实体最大数量。\n-1为默认值（禁用此限制）。");
    public static final ConfigInteger       SCULK_SENSOR_PULSE_LENGTH           = new ConfigInteger     ("sculkSensor | 幽匿感测体脉冲时长", 40, 0, 10000, "启用\"幽匿感测体脉冲时长（sculkSensorPulseLength）\"时，\n幽匿感测体的脉冲时长。");
    public static final ConfigBoolean       SHULKER_DISPLAY_BACKGROUND_COLOR    = new ConfigBoolean     ("shulkerDisplay | 潜影盒 - 背景颜色", true, "启用后，将根据潜影盒的染料颜色为其预览界面背景着色");
    public static final ConfigBoolean       SHULKER_DISPLAY_REQUIRE_SHIFT       = new ConfigBoolean     ("shulkerDisplay | 潜影盒 - 预览需按住Shift", true, "是否需按住Shift键显示潜影盒预览");
    public static final ConfigBoolean       SLOT_SYNC_WORKAROUND                = new ConfigBoolean     ("slotSync | 槽位同步修复", true, "防止服务器覆盖快速使用物品（例如通过快速右键功能）的耐久值或堆叠数量。");
    public static final ConfigBoolean       SLOT_SYNC_WORKAROUND_ALWAYS         = new ConfigBoolean     ("slotSync | 始终启用槽位同步修复", false, "始终在按住使用键时启用槽位同步修复，\n不仅限于快速右键或快速放置场景。\n主要用于其他需要持续使用物品的模组，\n如Litematica的轻松放置模式。");
    public static final ConfigBoolean       SNAP_AIM_INDICATOR                  = new ConfigBoolean     ("snapAim | 对齐视线 - 指示器", true, "是否显示快速瞄准角度指示器");
    public static final ConfigColor         SNAP_AIM_INDICATOR_COLOR            = new ConfigColor       ("snapAim | 对齐视线 - 指示器颜色", "#603030FF", "快速瞄准指示器的背景颜色");
    public static final ConfigOptionList    SNAP_AIM_MODE                       = new ConfigOptionList  ("snapAimMode | 对齐视线 - 模式", SnapAimMode.YAW, "快速瞄准模式：偏航角/俯仰角/两者兼顾");
    public static final ConfigBoolean       SNAP_AIM_ONLY_CLOSE_TO_ANGLE        = new ConfigBoolean     ("snapAim | 对齐视线 - 仅邻近角度", true, "启用后，仅当内部角度接近目标角度时才会触发快速瞄准\n具体阈值可通过\"对齐视线 - XX阈值（snapAimThreshold）\"设置");
    public static final ConfigBoolean       SNAP_AIM_PITCH_OVERSHOOT            = new ConfigBoolean     ("snapAim | 对齐视线 - 俯仰过冲", false, "是否允许俯仰角超出常规的±90度范围至±180度");
    public static final ConfigDouble        SNAP_AIM_PITCH_STEP                 = new ConfigDouble      ("snapAim | 对齐视线 - 俯仰步长", 12.5, 0, 90, "快速瞄准功能的俯仰角调整步长");
    public static final ConfigDouble        SNAP_AIM_THRESHOLD_PITCH            = new ConfigDouble      ("snapAim | 角度阈值（垂直方向）", 1.5, "玩家俯仰角与此阈值的接近度将触发快速瞄准角度对齐");
    public static final ConfigDouble        SNAP_AIM_THRESHOLD_YAW              = new ConfigDouble      ("snapAim | 角度阈值（水平方向）", 5.0, "玩家偏航角与此阈值的接近度将触发快速瞄准角度对齐");
    public static final ConfigDouble        SNAP_AIM_YAW_STEP                   = new ConfigDouble      ("snapAim | 对齐视线 - 偏航步长", 45, 0, 360, "快速瞄准功能的偏航角调整步长");
    public static final ConfigInteger       STRUCTURE_BLOCK_MAX_SIZE            = new ConfigInteger     ("structureBlock | 结构方块最大尺寸", 128, 1, 256, "结构方块保存区域的最大尺寸限制");
    public static final ConfigString        TOOL_SWITCHABLE_SLOTS               = new ConfigString      ("toolSwitch | 工具切换 - 可用槽位", "1-9", "工具切换功能允许存放新工具的槽位列表。\n注意：工具切换也可切换至快捷栏已有对应工具的槽位，\n但仅会将新工具交换到此处指定的槽位。");
    public static final ConfigString        TOOL_SWITCH_IGNORED_SLOTS           = new ConfigString      ("toolSwitch | 工具切换 - 忽略槽位", "", "工具切换功能在指定槽位激活时不生效的槽位列表");
    public static final ConfigBoolean       ZOOM_ADJUST_MOUSE_SENSITIVITY       = new ConfigBoolean     ("zoomAdjustMouse | 缩放调整鼠标灵敏度", true, "启用后，缩放功能激活时将降低鼠标灵敏度");
    public static final ConfigDouble        ZOOM_FOV                            = new ConfigDouble      ("zoomFov | 缩放视野", 30, 0.01, 359.99, "缩放功能使用的视野值（FOV）");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                CARPET_ACCURATE_PLACEMENT_PROTOCOL,
                CLIENT_PLACEMENT_ROTATION,
                FAST_LEFT_CLICK_ALLOW_TOOLS,
                FAST_PLACEMENT_REMEMBER_ALWAYS,
                FREE_CAMERA_PLAYER_INPUTS,
                FREE_CAMERA_PLAYER_MOVEMENT,
                HAND_RESTOCK_PRE,
                HANGABLE_ENTITY_BYPASS_INVERSE,
                ITEM_USE_PACKET_CHECK_BYPASS,
                PERMANENT_SNEAK_ALLOW_IN_GUIS,
                PLACEMENT_RESTRICTION_TIED_TO_FAST,
                POTION_WARNING_BENEFICIAL_ONLY,
                REMEMBER_FLEXIBLE,
                SHULKER_DISPLAY_BACKGROUND_COLOR,
                SHULKER_DISPLAY_REQUIRE_SHIFT,
                SLOT_SYNC_WORKAROUND,
                SLOT_SYNC_WORKAROUND_ALWAYS,
                SNAP_AIM_INDICATOR,
                SNAP_AIM_ONLY_CLOSE_TO_ANGLE,
                SNAP_AIM_PITCH_OVERSHOOT,
                ZOOM_ADJUST_MOUSE_SENSITIVITY,

                BLOCK_TYPE_BREAK_RESTRICTION_WARN,
                BREAKING_RESTRICTION_MODE,
                ELYTRA_CAMERA_INDICATOR,
                ENTITY_TYPE_ATTACK_RESTRICTION_WARN,
                PLACEMENT_RESTRICTION_MODE,
                HOTBAR_SWAP_OVERLAY_ALIGNMENT,
                SNAP_AIM_MODE,

                CHAT_TIME_FORMAT,
                CHAT_BACKGROUND_COLOR,
                FLEXIBLE_PLACEMENT_OVERLAY_COLOR,
                SNAP_AIM_INDICATOR_COLOR,

                AFTER_CLICKER_CLICK_COUNT,
                BLOCK_REACH_DISTANCE,
                BREAKING_GRID_SIZE,
                CUSTOM_INVENTORY_GUI_SCALE,
                FAST_BLOCK_PLACEMENT_COUNT,
                FAST_LEFT_CLICK_COUNT,
                FAST_RIGHT_CLICK_COUNT,
                FILL_CLONE_LIMIT,
                FLY_DECELERATION_FACTOR,
                FLY_SPEED_PRESET_1,
                FLY_SPEED_PRESET_2,
                FLY_SPEED_PRESET_3,
                FLY_SPEED_PRESET_4,
                GAMMA_OVERRIDE_VALUE,
                HAND_RESTOCK_PRE_THRESHOLD,
                HOTBAR_SLOT_CYCLE_MAX,
                HOTBAR_SLOT_RANDOMIZER_MAX,
                HOTBAR_SWAP_OVERLAY_OFFSET_X,
                HOTBAR_SWAP_OVERLAY_OFFSET_Y,
                ITEM_SWAP_DURABILITY_THRESHOLD,
                MAP_PREVIEW_SIZE,
                PERIODIC_ATTACK_INTERVAL,
                PERIODIC_USE_INTERVAL,
                PERIODIC_HOLD_ATTACK_DURATION,
                PERIODIC_HOLD_ATTACK_INTERVAL,
                PERIODIC_HOLD_USE_DURATION,
                PERIODIC_HOLD_USE_INTERVAL,
                PLACEMENT_GRID_SIZE,
                PLACEMENT_LIMIT,
                POTION_WARNING_THRESHOLD,
                RENDER_LIMIT_ITEM,
                RENDER_LIMIT_XP_ORB,
                SCULK_SENSOR_PULSE_LENGTH,
                SNAP_AIM_PITCH_STEP,
                SNAP_AIM_THRESHOLD_PITCH,
                SNAP_AIM_THRESHOLD_YAW,
                SNAP_AIM_YAW_STEP,
                STRUCTURE_BLOCK_MAX_SIZE,
                TOOL_SWITCHABLE_SLOTS,
                TOOL_SWITCH_IGNORED_SLOTS,
                ZOOM_FOV
        );
    }

    public static class Fixes
    {
        public static final ConfigBoolean ELYTRA_FIX                        = new ConfigBoolean("elytraFix | 鞘翅着陆修复", false, "由Earthcomputer和Nessie提供的鞘翅着陆修复。\n部署修复现已整合至原版，此功能仅影响着陆逻辑。");
        public static final ConfigBoolean MAC_HORIZONTAL_SCROLL             = new ConfigBoolean("macScroll | Mac水平滚动修复", false, "Mac/OSX系统专用修复，应用与hscroll模组相同的调整，\n同时避免破坏基于malilib框架模组的滚动功能。");
        public static final ConfigBoolean RAVAGER_CLIENT_BLOCK_BREAK_FIX    = new ConfigBoolean("ravager | 劫掠兽客户端破块修复", false, "修复劫掠兽客户端破坏方块导致的\n幽灵方块/方块同步异常问题");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                ELYTRA_FIX,
                MAC_HORIZONTAL_SCROLL,
                RAVAGER_CLIENT_BLOCK_BREAK_FIX
        );
    }

    public static class Lists
    {
        public static final ConfigOptionList BLOCK_TYPE_BREAK_RESTRICTION_LIST_TYPE = new ConfigOptionList("blockBreak | 方块破坏限制 - 列表类型", ListType.BLACKLIST, "方块破坏限制功能的「列表」设置");
        public static final ConfigStringList BLOCK_TYPE_BREAK_RESTRICTION_BLACKLIST = new ConfigStringList("blockBreak | 方块破坏限制 - 黑名单", ImmutableList.of("minecraft:budding_amethyst"), "当启用方块破坏限制且列表类型为黑名单时，\n禁止破坏此处列出的方块类型");
        public static final ConfigStringList BLOCK_TYPE_BREAK_RESTRICTION_WHITELIST = new ConfigStringList("blockBreak | 方块破坏限制 - 白名单", ImmutableList.of(), "当启用方块破坏限制且列表类型为白名单时，\n仅允许破坏此处列出的方块类型");
        public static final ConfigStringList CREATIVE_EXTRA_ITEMS               = new ConfigStringList("creativeExtra | 创造模式额外物品", ImmutableList.of("minecraft:command_block", "minecraft:chain_command_block", "minecraft:repeating_command_block", "minecraft:dragon_egg", "minecraft:structure_void", "minecraft:structure_block", "minecraft:structure_block{BlockEntityTag:{mode:\"SAVE\"}}", "minecraft:structure_block{BlockEntityTag:{mode:\"LOAD\"}}", "minecraft:structure_block{BlockEntityTag:{mode:\"CORNER\"}}"), "将额外物品添加至创造模式物品栏。\n当前这些物品会出现在运输类目下，\n未来将支持自定义物品分组。");
        public static final ConfigOptionList ENTITY_TYPE_ATTACK_RESTRICTION_LIST_TYPE = new ConfigOptionList("entityAttack | 实体攻击限制 - 列表类型", ListType.BLACKLIST, "实体攻击限制功能的列表类型设置");
        public static final ConfigStringList ENTITY_TYPE_ATTACK_RESTRICTION_BLACKLIST = new ConfigStringList("entityAttack | 实体攻击限制 - 黑名单", ImmutableList.of("minecraft:villager"), "当启用实体攻击限制且列表类型为黑名单时，\n禁止攻击此处列出的实体类型");
        public static final ConfigStringList ENTITY_TYPE_ATTACK_RESTRICTION_WHITELIST = new ConfigStringList("entityAttack | 实体攻击限制 - 白名单", ImmutableList.of(), "当启用实体攻击限制且列表类型为白名单时，\n仅允许攻击此处列出的实体类型");
        public static final ConfigStringList ENTITY_WEAPON_MAPPING              = new ConfigStringList("entityWeapon | 实体武器映射", ImmutableList.of("<default> => minecraft:diamond_sword, minecraft:golden_sword, minecraft:iron_sword, minecraft:netherite_sword, minecraft:stone_sword, minecraft:wooden_sword", "minecraft:end_crystal, minecraft:item_frame, minecraft:glow_item_frame, minecraft:leash_knot => <ignore>", "minecraft:minecart, minecraft:chest_minecart, minecraft:furnace_minecart, minecraft:hopper_minecart, minecraft:hopper_minecart, minecraft:spawner_minecart, minecraft:tnt_minecart, minecraft:boat=> minecraft:diamond_axe, minecraft:golden_axe, minecraft:iron_axe, minecraft:netherite_axe, minecraft:stone_axe, minecraft:wooden_axe"), "「自动切换武器（tweakWeaponSwitch）」的武器映射配置。\n\n\"<default>\"用于未定义映射时的配置，\n\"<ignore>\"表示不能触发自动切换武器的配置。");
        public static final ConfigOptionList FAST_PLACEMENT_ITEM_LIST_TYPE      = new ConfigOptionList("fast | 快速放置 - 物品列表类型", ListType.BLACKLIST, "快速方块放置功能的物品限制类型");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_BLACKLIST      = new ConfigStringList("fast | 快速放置 - 物品黑名单", ImmutableList.of("minecraft:ender_chest", "minecraft:white_shulker_box"), "当快速放置物品列表类型为黑名单时，\n禁止使用此处列出的物品进行快速放置");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_WHITELIST      = new ConfigStringList("fast | 快速放置 - 物品白名单", ImmutableList.of(), "当快速放置物品列表类型为白名单时，\n仅允许使用此处列出的物品进行快速放置");
        public static final ConfigOptionList FAST_RIGHT_CLICK_BLOCK_LIST_TYPE   = new ConfigOptionList("fast | 快速右键 - 方块列表类型", ListType.BLACKLIST, "快速右键功能的方块目标限制类型");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_BLACKLIST   = new ConfigStringList("fast | 快速右键 - 方块黑名单", ImmutableList.of("minecraft:chest", "minecraft:ender_chest", "minecraft:trapped_chest", "minecraft:white_shulker_box"), "当快速右键方块列表类型为黑名单时，\n禁止对此处列出的方块使用快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_WHITELIST   = new ConfigStringList("fast | 快速右键 - 方块白名单", ImmutableList.of(), "当快速右键方块列表类型为白名单时，\n仅允许对此处列出的方块使用快速右键");
        public static final ConfigOptionList FAST_RIGHT_CLICK_ITEM_LIST_TYPE    = new ConfigOptionList("fast | 快速右键 - 物品列表类型", ListType.NONE, "快速右键功能的物品限制类型");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_BLACKLIST    = new ConfigStringList("fast | 快速右键 - 物品黑名单", ImmutableList.of("minecraft:firework_rocket"), "当快速右键物品列表类型为黑名单时，\\\n禁止使用此处列出的物品进行快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_WHITELIST    = new ConfigStringList("fast | 快速右键 - 物品白名单", ImmutableList.of("minecraft:bucket", "minecraft:water_bucket", "minecraft:lava_bucket", "minecraft:glass_bottle"), "当快速右键物品列表类型为白名单时，\n仅允许使用此处列出的物品进行快速右键");
        public static final ConfigStringList FLAT_WORLD_PRESETS                 = new ConfigStringList("flatWorld | 超平坦世界预设", ImmutableList.of("White Glass;1*minecraft:white_stained_glass;minecraft:plains;;minecraft:white_stained_glass", "Glass;1*minecraft:glass;minecraft:plains;;minecraft:glass"), "自定义超平坦世界预设格式：\n名称;方块字符串;生物群系;生成特征;图标物品\n方块字符串使用原版格式，例如：62*minecraft:dirt,minecraft:grass\n生物群系可使用注册名或数字ID\n图标物品格式示例：minecraft:iron_nugget");
        public static final ConfigOptionList HAND_RESTOCK_LIST_TYPE             = new ConfigOptionList("handRestock | 自动补货 - 列表类型", ListType.NONE, "自动补货功能的黑白名单列表类型");
        public static final ConfigStringList HAND_RESTOCK_BLACKLIST             = new ConfigStringList("handRestock | 自动补货 - 黑名单", ImmutableList.of("minecraft:bucket", "minecraft:lava_bucket", "minecraft:water_bucket"), "当自动补货列表类型为黑名单时，禁止对此处列出的物品进行补货");
        public static final ConfigStringList HAND_RESTOCK_WHITELIST             = new ConfigStringList("handRestock | 自动补货 - 白名单", ImmutableList.of(), "当自动补货列表类型为白名单时，仅允许对此处列出的物品进行补货");
        public static final ConfigOptionList POTION_WARNING_LIST_TYPE           = new ConfigOptionList("potion | 药水警告 - 列表类型", ListType.NONE, "药水效果警告的列表类型设置");
        public static final ConfigStringList POTION_WARNING_BLACKLIST           = new ConfigStringList("potion | 药水警告 - 黑名单", ImmutableList.of("minecraft:hunger", "minecraft:mining_fatigue", "minecraft:nausea", "minecraft:poison", "minecraft:slowness", "minecraft:weakness"), "此处列出的药水效果将不会触发警告");
        public static final ConfigStringList POTION_WARNING_WHITELIST           = new ConfigStringList("potion | 药水警告 - 白名单", ImmutableList.of("minecraft:fire_resistance", "minecraft:invisibility", "minecraft:water_breathing"), "仅此处列出的药水效果会触发警告");
        public static final ConfigStringList REPAIR_MODE_SLOTS                  = new ConfigStringList("repair | 修复模式槽位", ImmutableList.of("mainhand", "offhand"), "设置修复模式生效的装备槽位\n有效值：\n 主手(mainhand)，副手(offhand)，\n 头部(head)，胸部(chest)，腿部(legs)，脚部(feet)");
        public static final ConfigStringList UNSTACKING_ITEMS                   = new ConfigStringList("unstacking | 溢出背包保护物品", ImmutableList.of("minecraft:bucket", "minecraft:glass_bottle"), "启用物品溢出背包保护（tweakItemUnstackingProtection）功能时\n需要保护防止因为背包满了而被丢弃扔出的物品的列表");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                BLOCK_TYPE_BREAK_RESTRICTION_LIST_TYPE,
                BLOCK_TYPE_BREAK_RESTRICTION_BLACKLIST,
                BLOCK_TYPE_BREAK_RESTRICTION_WHITELIST,
                CREATIVE_EXTRA_ITEMS,
                ENTITY_TYPE_ATTACK_RESTRICTION_LIST_TYPE,
                ENTITY_TYPE_ATTACK_RESTRICTION_BLACKLIST,
                ENTITY_TYPE_ATTACK_RESTRICTION_WHITELIST,
                ENTITY_WEAPON_MAPPING,
                FAST_PLACEMENT_ITEM_LIST_TYPE,
                FAST_RIGHT_CLICK_BLOCK_LIST_TYPE,
                FAST_RIGHT_CLICK_ITEM_LIST_TYPE,
                POTION_WARNING_LIST_TYPE,
                FAST_PLACEMENT_ITEM_BLACKLIST,
                FAST_PLACEMENT_ITEM_WHITELIST,
                FAST_RIGHT_CLICK_BLOCK_BLACKLIST,
                FAST_RIGHT_CLICK_BLOCK_WHITELIST,
                FAST_RIGHT_CLICK_ITEM_BLACKLIST,
                FAST_RIGHT_CLICK_ITEM_WHITELIST,
                FLAT_WORLD_PRESETS,
                HAND_RESTOCK_LIST_TYPE,
                HAND_RESTOCK_BLACKLIST,
                HAND_RESTOCK_WHITELIST,
                POTION_WARNING_BLACKLIST,
                POTION_WARNING_WHITELIST,
                REPAIR_MODE_SLOTS,
                UNSTACKING_ITEMS
        );
    }

    public static class Disable
    {
        public static final ConfigBooleanHotkeyed       DISABLE_ARMOR_STAND_RENDERING   = new ConfigBooleanHotkeyed("ArmorStand | 禁用 - 盔甲架渲染",           false, "", "禁用所有盔甲架的实体渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_AXE_STRIPPING           = new ConfigBooleanHotkeyed("AxeStripping | 禁用 - 斧头去皮",                  false, "", "禁用使用斧头剥离原木等方块");
        public static final ConfigBooleanHotkeyed       DISABLE_BAT_SPAWNING            = new ConfigBooleanClient  ("disableBatSpawning",                   false, "", "在单人游戏中禁用蝙蝠生成");
        public static final ConfigBooleanHotkeyed       DISABLE_BEACON_BEAM_RENDERING   = new ConfigBooleanHotkeyed("BeaconBeam | 禁用 - 信标光束渲染",           false, "", "移除信标的光束渲染效果");
        public static final ConfigBooleanHotkeyed       DISABLE_BLOCK_BREAK_PARTICLES   = new ConfigBooleanHotkeyed("Block | 禁用 - 方块破坏粒子",        false, "", "移除方块破坏时的粒子效果\n（此功能最初来自Nessie的usefulmod）");
        public static final ConfigBooleanHotkeyed       DISABLE_DOUBLE_TAP_SPRINT       = new ConfigBooleanHotkeyed("DoubleTapSprint | 禁用 - 双击前进疾跑",               false, "", "禁用双击前进键触发疾跑");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_BAR                = new ConfigBooleanHotkeyed("BossBar | 禁用 - Boss血条",                       false, "", "禁用Boss血条显示");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_FOG                = new ConfigBooleanHotkeyed("BossFog | 禁用 - Boss雾效",                       false, "", "移除Boss生物生成的雾效");
        public static final ConfigBooleanHotkeyed       DISABLE_CHUNK_RENDERING         = new ConfigBooleanHotkeyed("Chunk | 禁用 - 区块渲染",                false, "", "停止区块的（重）渲染。此功能启用期间任何方块变化将不可见，\n需关闭后使用F3 + A刷新世界渲染。\n在存在大量无关紧要的方块变化场景中，可能有助于提升帧率。");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_ENTITY_UPDATES   = new ConfigBooleanHotkeyed("ClientEntity | 禁用 - 客户端实体更新",           false, "", "在客户端禁用除玩家外的所有实体更新。\n主要用于需要处理大量实体导致性能问题时临时修复。");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_LIGHT_UPDATES    = new ConfigBooleanHotkeyed("Client | 禁用 - 客户端光照更新",            false, "", "禁用所有客户端光照更新");
        public static final ConfigBooleanHotkeyed       DISABLE_CONSTANT_CHUNK_SAVING   = new ConfigBooleanHotkeyed("ChunkSaving | 禁用 - 持续区块保存",           false, "", "禁用游戏每刻自动保存最多20个区块的功能\n（不影响常规自动保存周期）");
        public static final ConfigBooleanHotkeyed       DISABLE_CREATIVE_INFESTED_BLOCKS= new ConfigBooleanHotkeyed("festedBlocks | 禁用 - 创造模式菜单的虫蚀方块",    false, "", "从创造模式搜索栏移除虫蚀方块");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_RENDERING      = new ConfigBooleanHotkeyed("DeadMob | 禁用 - 死亡生物渲染",              false, "", "阻止渲染已死亡生物（生命值为0的实体）");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_TARGETING      = new ConfigBooleanHotkeyed("DeadMob | 禁用 - 死亡生物目标选择",              false, "", "阻止目标选择到已死亡实体\n避免攻击已死亡生物的问题");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_RENDERING        = new ConfigBooleanHotkeyed("Entity | 禁用 - 实体渲染",               false, "", "禁用除玩家外的所有实体渲染\n主要用于需要处理大量实体导致性能问题时临时修复");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_TICKING          = new ConfigBooleanClient  ("disableEntityTicking",                 false, "", "阻止除玩家外所有实体的更新");
        public static final ConfigBooleanHotkeyed       DISABLE_FALLING_BLOCK_RENDER    = new ConfigBooleanHotkeyed("FallingBlock | 禁用 - 下落方块渲染",   false, "", "启用后，下落方块实体将完全不可见");
        public static final ConfigBooleanHotkeyed       DISABLE_FP_EFFECT_PARTICLES     = new ConfigBooleanHotkeyed("FirstPerson | 禁用 - 第一人称药水粒子",    false, "", "移除第一人称视角的药水效果粒子/漩涡特效\n（来自玩家自身的效果）");
        public static final ConfigBooleanHotkeyed       DISABLE_INVENTORY_EFFECTS       = new ConfigBooleanHotkeyed("InventoryEffect | 禁用 - 背包药水效果显示",      false, "", "移除背包界面中的药水效果显示");
        public static final ConfigBooleanHotkeyed       DISABLE_ITEM_SWITCH_COOLDOWN    = new ConfigBooleanHotkeyed("ItemSwitch | 禁用 - 物品切换动画",      false, "", "启用后，切换手持物品或使用物品时\n将不显示冷却/装备动画");
        public static final ConfigBooleanHotkeyed       DISABLE_MOB_SPAWNER_MOB_RENDER  = new ConfigBooleanHotkeyed("MobSpawnerMob | 禁用 - 刷怪笼生物渲染",        false, "", "移除刷怪笼中的生物模型渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_NAUSEA_EFFECT           = new ConfigBooleanHotkeyed("NauseaEffect | 禁用 - 恶心效果",                  false, "", "禁用恶心效果的视觉扭曲");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_FOG              = new ConfigBooleanHotkeyed("NetherFog | 禁用 - 下界雾效",                     false, "", "移除下界维度中的雾效");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_PORTAL_SOUND     = new ConfigBooleanHotkeyed("NetherPortal | 禁用 - 下界传送门音效",             false, "", "禁用下界传送门的嗡鸣声");
        public static final ConfigBooleanHotkeyed       DISABLE_OBSERVER                = new ConfigBooleanClient  ("disableObserver",                      false, "", "完全禁用侦测器的触发功能");
        public static final ConfigBooleanHotkeyed       DISABLE_OFFHAND_RENDERING       = new ConfigBooleanHotkeyed("Offhand | 禁用 - 副手物品渲染",              false, "", "禁用副手物品的渲染显示");
        public static final ConfigBooleanHotkeyed       DISABLE_PARTICLES               = new ConfigBooleanHotkeyed("Particles | 禁用 - 所有粒子效果",                     false, "", "禁用所有粒子效果显示");
        public static final ConfigBooleanHotkeyed       DISABLE_PORTAL_GUI_CLOSING      = new ConfigBooleanHotkeyed("PortalGuiClosing | 禁用 - 传送门关闭界面",              false, "", "启用后，身处下界传送门时仍可打开各类界面");
        public static final ConfigBooleanHotkeyed       DISABLE_RAIN_EFFECTS            = new ConfigBooleanHotkeyed("RainEffects | 禁用 - 降雨效果",                   false, "", "禁用降雨的视觉效果和音效");
        public static final ConfigBooleanHotkeyed       DISABLE_RENDERING_SCAFFOLDING   = new ConfigBooleanHotkeyed("Renderingscaffold | 禁用 - 脚手架渲染",          false, "", "禁用脚手架方块的渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_RENDER_DISTANCE_FOG     = new ConfigBooleanHotkeyed("Render | 禁用 - 渲染距离雾效",             false, "", "禁用渲染距离边缘的雾效渐变");
        public static final ConfigBooleanHotkeyed       DISABLE_SCOREBOARD_RENDERING    = new ConfigBooleanHotkeyed("Scoreboard | 禁用 - 计分板显示",           false, "", "移除侧边栏计分板的显示");
        public static final ConfigBooleanHotkeyed       DISABLE_SHULKER_BOX_TOOLTIP     = new ConfigBooleanHotkeyed("SBoxTooltip | 禁用 - 潜影盒原版提示",             false, "", "禁用潜影盒的原版物品栏提示文本");
        public static final ConfigBooleanHotkeyed       DISABLE_SHOVEL_PATHING          = new ConfigBooleanHotkeyed("ShovelPathing | 禁用 - 铲子铺路",                 false, "", "禁用使用铲子将草方块转换为小径方块");
        public static final ConfigBooleanHotkeyed       DISABLE_SIGN_GUI                = new ConfigBooleanHotkeyed("SignGui | 禁用 - 告示牌界面",                       false, "", "阻止打开告示牌编辑界面");
        public static final ConfigBooleanHotkeyed       DISABLE_SKY_DARKNESS            = new ConfigBooleanHotkeyed("SkyDarkness | 禁用 - 天空暗化",                   false, "", "禁用y=63以下的天空暗化效果\n（通过将阈值调整为世界底部以下2格实现）");
        public static final ConfigBooleanHotkeyed       DISABLE_SLIME_BLOCK_SLOWDOWN    = new ConfigBooleanHotkeyed("SlimeBlock | 禁用 - 粘液块减速",            false, "", "移除在粘液块上行走的减速效果\n（此功能最初来自Nessie的usefulmod）");
        public static final ConfigBooleanHotkeyed       DISABLE_STATUS_EFFECT_HUD       = new ConfigBooleanHotkeyed("EffectHud | 禁用 - 状态效果HUD",               false, "", "禁用状态效果HUD显示（通常位于屏幕右上角）");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_RENDERING   = new ConfigBooleanHotkeyed("TileEntity | 禁用 - 方块实体渲染",           false, "", "阻止所有方块实体的渲染器工作");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_TICKING     = new ConfigBooleanClient  ("disableTileEntityTicking",             false, "", "阻止所有方块实体的更新");
        public static final ConfigBooleanHotkeyed       DISABLE_VILLAGER_TRADE_LOCKING  = new ConfigBooleanClient  ("disableVillagerTradeLocking",          false, "", "通过同步增加配方使用次数与最大使用次数，\n防止村民交易被永久锁定");
        public static final ConfigBooleanHotkeyed       DISABLE_WALL_UNSPRINT           = new ConfigBooleanHotkeyed("WallUnsprint | 禁用 - 碰墙停止疾跑",                  false, "", "触碰墙壁时不会退出疾跑状态");
        public static final ConfigBooleanHotkeyed       DISABLE_WORLD_VIEW_BOB          = new ConfigBooleanHotkeyed("WorldViewBob | 禁用 - 视角晃动",                  false, "", "禁用世界视角的晃动效果（不影响手持物品晃动）\n注意：安装Iris模组时此设置可能失效");

        public static final ImmutableList<IHotkeyTogglable> OPTIONS = ImmutableList.of(
                DISABLE_ARMOR_STAND_RENDERING,
                DISABLE_AXE_STRIPPING,
                DISABLE_BAT_SPAWNING,
                DISABLE_BEACON_BEAM_RENDERING,
                DISABLE_BLOCK_BREAK_PARTICLES,
                DISABLE_DOUBLE_TAP_SPRINT,
                DISABLE_BOSS_BAR,
                DISABLE_BOSS_FOG,
                DISABLE_CHUNK_RENDERING,
                DISABLE_CLIENT_ENTITY_UPDATES,
                DISABLE_CLIENT_LIGHT_UPDATES,
                DISABLE_CONSTANT_CHUNK_SAVING,
                DISABLE_CREATIVE_INFESTED_BLOCKS,
                DISABLE_DEAD_MOB_RENDERING,
                DISABLE_DEAD_MOB_TARGETING,
                DISABLE_ENTITY_RENDERING,
                DISABLE_ENTITY_TICKING,
                DISABLE_FALLING_BLOCK_RENDER,
                DISABLE_FP_EFFECT_PARTICLES,
                DISABLE_INVENTORY_EFFECTS,
                DISABLE_ITEM_SWITCH_COOLDOWN,
                DISABLE_MOB_SPAWNER_MOB_RENDER,
                DISABLE_NAUSEA_EFFECT,
                DISABLE_NETHER_FOG,
                DISABLE_NETHER_PORTAL_SOUND,
                DISABLE_OBSERVER,
                DISABLE_OFFHAND_RENDERING,
                DISABLE_PARTICLES,
                DISABLE_PORTAL_GUI_CLOSING,
                DISABLE_RAIN_EFFECTS,
                DISABLE_RENDERING_SCAFFOLDING,
                DISABLE_RENDER_DISTANCE_FOG,
                DISABLE_SCOREBOARD_RENDERING,
                DISABLE_SHULKER_BOX_TOOLTIP,
                DISABLE_SHOVEL_PATHING,
                DISABLE_SIGN_GUI,
                DISABLE_SKY_DARKNESS,
                DISABLE_SLIME_BLOCK_SLOWDOWN,
                DISABLE_STATUS_EFFECT_HUD,
                DISABLE_TILE_ENTITY_RENDERING,
                DISABLE_TILE_ENTITY_TICKING,
                DISABLE_VILLAGER_TRADE_LOCKING,
                DISABLE_WALL_UNSPRINT,
                DISABLE_WORLD_VIEW_BOB
        );
    }

    public static class Internal
    {
        public static final ConfigInteger       FLY_SPEED_PRESET                    = new ConfigInteger     ("flySpeedPreset", 0, 0, 3, "此值仅供模组内部使用，用于追踪\n当前选择的飞行速度预设方案");
        public static final ConfigDouble        GAMMA_VALUE_ORIGINAL                = new ConfigDouble      ("gammaValueOriginal", 0, 0, 1, "伽马覆盖功能启用前的原始亮度值");
        public static final ConfigInteger       HOTBAR_SCROLL_CURRENT_ROW           = new ConfigInteger     ("hotbarScrollCurrentRow", 3, 0, 3, "此值仅供模组内部使用，用于追踪\n快捷栏滚动功能的「当前快捷栏行」状态");
        public static final ConfigDouble        SLIME_BLOCK_SLIPPERINESS_ORIGINAL   = new ConfigDouble      ("slimeBlockSlipperinessOriginal", 0.8, 0, 1, "粘液块原本的滑动系数值");
        public static final ConfigDouble        SNAP_AIM_LAST_PITCH                 = new ConfigDouble      ("snapAimLastPitch", 0, -135, 135, "最后一次对齐视线时的俯仰角数值");
        public static final ConfigDouble        SNAP_AIM_LAST_YAW                   = new ConfigDouble      ("snapAimLastYaw", 0, 0, 360, "最后一次对齐视线时的偏航角数值");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                FLY_SPEED_PRESET,
                GAMMA_VALUE_ORIGINAL,
                HOTBAR_SCROLL_CURRENT_ROW,
                SLIME_BLOCK_SLIPPERINESS_ORIGINAL,
                SNAP_AIM_LAST_YAW
        );
    }

    public static ConfigDouble getActiveFlySpeedConfig()
    {
        switch (Configs.Internal.FLY_SPEED_PRESET.getIntegerValue())
        {
            case 0:  return Configs.Generic.FLY_SPEED_PRESET_1;
            case 1:  return Configs.Generic.FLY_SPEED_PRESET_2;
            case 2:  return Configs.Generic.FLY_SPEED_PRESET_3;
            case 3:  return Configs.Generic.FLY_SPEED_PRESET_4;
            default: return Configs.Generic.FLY_SPEED_PRESET_1;
        }
    }

    public static void loadFromFile()
    {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);

        if (configFile.exists() && configFile.isFile() && configFile.canRead())
        {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject())
            {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Fixes", Configs.Fixes.OPTIONS);
                ConfigUtils.readConfigBase(root, "Generic", Configs.Generic.OPTIONS);
                ConfigUtils.readConfigBase(root, "GenericHotkeys", Hotkeys.HOTKEY_LIST);
                ConfigUtils.readConfigBase(root, "Internal", Configs.Internal.OPTIONS);
                ConfigUtils.readConfigBase(root, "Lists", Configs.Lists.OPTIONS);
                ConfigUtils.readHotkeyToggleOptions(root, "DisableHotkeys", "DisableToggles", Disable.OPTIONS);
                ConfigUtils.readHotkeyToggleOptions(root, "TweakHotkeys", "TweakToggles", FeatureToggle.VALUES);
            }
        }

        // TODO 1.19.3+
        //CreativeExtraItems.setCreativeExtraItems(Lists.CREATIVE_EXTRA_ITEMS.getStrings());

        InventoryUtils.setToolSwitchableSlots(Generic.TOOL_SWITCHABLE_SLOTS.getStringValue());
        InventoryUtils.setToolSwitchIgnoreSlots(Generic.TOOL_SWITCH_IGNORED_SLOTS.getStringValue());
        InventoryUtils.setRepairModeSlots(Lists.REPAIR_MODE_SLOTS.getStrings());
        InventoryUtils.setUnstackingItems(Lists.UNSTACKING_ITEMS.getStrings());
        InventoryUtils.setWeaponMapping(Lists.ENTITY_WEAPON_MAPPING.getStrings());

        PlacementTweaks.BLOCK_TYPE_BREAK_RESTRICTION.setListType((ListType) Lists.BLOCK_TYPE_BREAK_RESTRICTION_LIST_TYPE.getOptionListValue());
        PlacementTweaks.BLOCK_TYPE_BREAK_RESTRICTION.setListContents(
                Lists.BLOCK_TYPE_BREAK_RESTRICTION_BLACKLIST.getStrings(),
                Lists.BLOCK_TYPE_BREAK_RESTRICTION_WHITELIST.getStrings());

        PlacementTweaks.FAST_RIGHT_CLICK_BLOCK_RESTRICTION.setListType((ListType) Lists.FAST_RIGHT_CLICK_BLOCK_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_RIGHT_CLICK_BLOCK_RESTRICTION.setListContents(
                Lists.FAST_RIGHT_CLICK_BLOCK_BLACKLIST.getStrings(),
                Lists.FAST_RIGHT_CLICK_BLOCK_WHITELIST.getStrings());

        PlacementTweaks.FAST_RIGHT_CLICK_ITEM_RESTRICTION.setListType((ListType) Lists.FAST_RIGHT_CLICK_ITEM_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_RIGHT_CLICK_ITEM_RESTRICTION.setListContents(
                Lists.FAST_RIGHT_CLICK_ITEM_BLACKLIST.getStrings(),
                Lists.FAST_RIGHT_CLICK_ITEM_WHITELIST.getStrings());

        PlacementTweaks.FAST_PLACEMENT_ITEM_RESTRICTION.setListType((ListType) Lists.FAST_PLACEMENT_ITEM_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_PLACEMENT_ITEM_RESTRICTION.setListContents(
                Lists.FAST_PLACEMENT_ITEM_BLACKLIST.getStrings(),
                Lists.FAST_PLACEMENT_ITEM_WHITELIST.getStrings());

        PlacementTweaks.HAND_RESTOCK_RESTRICTION.setListType((ListType) Lists.HAND_RESTOCK_LIST_TYPE.getOptionListValue());
        PlacementTweaks.HAND_RESTOCK_RESTRICTION.setListContents(
                Lists.HAND_RESTOCK_BLACKLIST.getStrings(),
                Lists.HAND_RESTOCK_WHITELIST.getStrings());

        MiscTweaks.POTION_RESTRICTION.setListType((ListType) Lists.POTION_WARNING_LIST_TYPE.getOptionListValue());
        MiscTweaks.POTION_RESTRICTION.setListContents(
                Lists.POTION_WARNING_BLACKLIST.getStrings(),
                Lists.POTION_WARNING_WHITELIST.getStrings());

        MiscTweaks.ENTITY_TYPE_ATTACK_RESTRICTION.setListType((ListType) Lists.ENTITY_TYPE_ATTACK_RESTRICTION_LIST_TYPE.getOptionListValue());
        MiscTweaks.ENTITY_TYPE_ATTACK_RESTRICTION.setListContents(
                Lists.ENTITY_TYPE_ATTACK_RESTRICTION_BLACKLIST.getStrings(),
                Lists.ENTITY_TYPE_ATTACK_RESTRICTION_WHITELIST.getStrings());

        if (MinecraftClient.getInstance().world == null)
        {
            // Turn off after loading the configs, just in case it was enabled in the config somehow.
            // But only if we are currently not in a world, since changing configs also re-loads them when closing the menu.
            FeatureToggle.TWEAK_FREE_CAMERA.setBooleanValue(false);
        }
    }

    public static void saveToFile()
    {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs())
        {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Fixes", Configs.Fixes.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            ConfigUtils.writeConfigBase(root, "GenericHotkeys", Hotkeys.HOTKEY_LIST);
            ConfigUtils.writeConfigBase(root, "Internal", Configs.Internal.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Lists", Configs.Lists.OPTIONS);
            ConfigUtils.writeHotkeyToggleOptions(root, "DisableHotkeys", "DisableToggles", Disable.OPTIONS);
            ConfigUtils.writeHotkeyToggleOptions(root, "TweakHotkeys", "TweakToggles", FeatureToggle.VALUES);

            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    @Override
    public void load()
    {
        loadFromFile();
    }

    @Override
    public void save()
    {
        saveToFile();
    }
}