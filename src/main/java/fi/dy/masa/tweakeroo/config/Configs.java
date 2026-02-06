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
    public static final ConfigOptionList    BLOCK_TYPE_BREAK_RESTRICTION_WARN   = new ConfigOptionList  ("blockBreakWarn | 破坏限制告警", MessageOutputType.MESSAGE, "当“方块类型破坏限制”阻止破坏方块时，\n将显示哪种类型的警告消息(如果有的话)");
    public static final ConfigInteger       BREAKING_GRID_SIZE                  = new ConfigInteger     ("breaking | 破坏间隔调节", 3, 1, 1000, "破坏间隔距离设置，按住此功能快捷键时滑动滚轮可以快速调整。");
    public static final ConfigOptionList    BREAKING_RESTRICTION_MODE           = new ConfigOptionList  ("breaking | 破坏模式限制方式调节", PlacementRestrictionMode.LINE, "选择要使用的破坏限制模式。（也可使用快捷键选择）");
    public static final ConfigColor         CHAT_BACKGROUND_COLOR               = new ConfigColor       ("chatBack | 聊天背景颜色", "#80000000", "设定聊天栏背景颜色，需要开启§6聊天背景颜色§6功能使用。");
    public static final ConfigString        CHAT_TIME_FORMAT                    = new ConfigString      ("chatTime | 聊天时间格式", "[HH:mm:ss]", "§6聊天时间显示§f功能所显示的时间格式。\n请使用Java的简易日期格式。");
    public static final ConfigBoolean       CARPET_ACCURATE_PLACEMENT_PROTOCOL  = new ConfigBoolean     ("carpetAccurate | Carpet精确放置协议", true, "If enabled, then the Flexible Block Placement and the\nAccurate Block Placement use the protocol implemented in Carpet mod.\n§6Note: This is required for any block rotations to work, other than\n§6blocks that only care about the block side you click on (Hoppers, Logs etc.) \n# 开启后，灵活放置和精确放置将使用 Carpet 模组协议。\n§6注意：除仅关心点击面（如漏斗、原木等）的方块外，其他方块旋转都需要此功能。");
    public static final ConfigBoolean       CLIENT_PLACEMENT_ROTATION           = new ConfigBoolean     ("clientPlacement | 客户端放置旋转", true, "允许在单人游戏中放置旋转后的方块。\n功能类似\\\"精确放置\\\"但这不需要§eCarpet MOD§f。");
    public static final ConfigInteger       CUSTOM_INVENTORY_GUI_SCALE          = new ConfigInteger     ("InventoryGui | 自定义容器比例", 2, 1, 10, "为所有容器界面使用自定义缩放比例\n缩放值见“通用”中的“自定义背包界面缩放（customInventoryGuiScale）”");
    public static final ConfigOptionList    ELYTRA_CAMERA_INDICATOR             = new ConfigOptionList  ("elytraCamera | 显示仰角指示器", ActiveMode.WITH_KEY, "当使用§6四周环顾§f时，显示仰角指示器。");
    public static final ConfigOptionList    ENTITY_TYPE_ATTACK_RESTRICTION_WARN = new ConfigOptionList  ("entityAttackWarn | 攻击限制告警", MessageOutputType.MESSAGE, "当“实体类型攻击限制”阻止攻击实体时，\n将显示哪种类型的警告消息(如果有的话)");
    public static final ConfigInteger       FAST_BLOCK_PLACEMENT_COUNT          = new ConfigInteger     ("fastBlock | 快速放置数量", 2, 1, 16, "§6方块快速放置§f功能在每游戏刻能够放置方块的最大数量。");
    public static final ConfigBoolean       FAST_LEFT_CLICK_ALLOW_TOOLS         = new ConfigBoolean     ("LeftClickTools | 左键连点工具兼容", false, "在生存当中开启左键快速点击将兼容工具\n§b金合欢：你们挖区块都不开连点的吗？");
    public static final ConfigInteger       FAST_LEFT_CLICK_COUNT               = new ConfigInteger     ("fastLeft | 左键快速点击频率",  10, 1, 64, "设置§6左键快速点击§f的点击频率，数字为每游戏刻点击的次数。");
    public static final ConfigBoolean       FAST_PLACEMENT_REMEMBER_ALWAYS      = new ConfigBoolean     ("fastPlacement | 快速放置记忆", true, "启用后，快速方块放置将始终记忆首个放置方块的朝向。\n未启用时，仅当灵活放置功能激活时才会记忆朝向。");
    public static final ConfigInteger       FAST_RIGHT_CLICK_COUNT              = new ConfigInteger     ("fastRight | 右键快速点击频率", 10, 1, 64, "设置§6右键快速点击§f的点击频率，数字为每游戏刻点击的次数。");
    public static final ConfigInteger       FILL_CLONE_LIMIT                    = new ConfigInteger     ("fillClone | 填充方块上限", 10000000, 1, 1000000000, "设置§6更改填充方块上限§f功能的填充/克隆指令方块上限。\n§6注意：此功能在多人游戏中不生效。");
    public static final ConfigColor         FLEXIBLE_PLACEMENT_OVERLAY_COLOR    = new ConfigColor       ("flexibleBlock | 灵活放置GUI颜色", "#C03030F0", "设定§6方块灵活放置§f功能启用时方块上覆盖层的颜色。");
    public static final ConfigDouble        FLY_DECELERATION_FACTOR             = new ConfigDouble      ("flyDeceleration | 飞行阻力因素", 0.4, 0.0, 1.0, "如果启用“飞行减速”功能，\n将调整玩家创造飞行时的停止速度（数值越大惯性越大）");
    public static final ConfigDouble        FLY_SPEED_PRESET_1                  = new ConfigDouble      ("flySpeed | 飞行速度预设1", 0.01, 0, 4, "飞行速度的预设值1。");
    public static final ConfigDouble        FLY_SPEED_PRESET_2                  = new ConfigDouble      ("flySpeed | 飞行速度预设2", 0.064, 0, 4, "飞行速度的预设值2。");
    public static final ConfigDouble        FLY_SPEED_PRESET_3                  = new ConfigDouble      ("flySpeed | 飞行速度预设3", 0.128, 0, 4, "飞行速度的预设值3。");
    public static final ConfigDouble        FLY_SPEED_PRESET_4                  = new ConfigDouble      ("flySpeed | 飞行速度预设4", 0.32, 0, 4, "飞行速度的预设值4。");
    public static final ConfigBoolean       FREE_CAMERA_PLAYER_INPUTS           = new ConfigBoolean     ("freeCam | 灵魂出窍玩家操作", false, "启用后，灵魂出窍模式中的\n攻击和使用动作（即左右键）将传递给实际玩家角色。");
    public static final ConfigBoolean       FREE_CAMERA_PLAYER_MOVEMENT         = new ConfigBoolean     ("freeCamPlayer | 灵魂/身体操作切换", false, "开启此功能后，§6灵魂出窍§f的开关会与§6灵魂/身体操作切换§f的开关绑定在一起。\n也就是说，你每次开启灵魂出窍后会默认操控身体而不是视角。");
    public static final ConfigDouble        GAMMA_OVERRIDE_VALUE                = new ConfigDouble      ("gammaOverride | 覆写伽马设定", 16, 0, 32, "启用§6伽马覆写§f后，所覆写的伽马值。");
    public static final ConfigBoolean       HAND_RESTOCK_PRE                    = new ConfigBoolean     ("handRestockPre | 预先补货", true, "开启后会在手上的物品耗尽前提前补充新的物品。");
    public static final ConfigInteger       HAND_RESTOCK_PRE_THRESHOLD          = new ConfigInteger     ("handRestock | 自动补货阈值", 6, 1, 64, "在自动补货模式下的补货阈值");
    public static final ConfigBoolean       HANGABLE_ENTITY_BYPASS_INVERSE      = new ConfigBoolean     ("hangableEntity | 悬挂实体交互方式", false, "若启用悬挂实体目标绕过功能，此选项控制玩家是否需要潜行\n才能选中悬挂实体（物品展示框或画作）。\n > true - 潜行时忽略实体\n > false - 潜行时选中实体");
    public static final ConfigInteger       HOTBAR_SLOT_CYCLE_MAX               = new ConfigInteger     ("hotbarSlot | 物品栏循环上限", 2, 1, 9, "设定§6物品栏循环滚动§f可以滚动到的最后一个栏位。\n当超过设定的最大值时，会返回第一个栏位。");
    public static final ConfigInteger       HOTBAR_SLOT_RANDOMIZER_MAX          = new ConfigInteger     ("hotbarSlot | 物品栏随机上限", 5, 1, 9, "设定§6物品栏随机滚动§f可以滚动到的最后一个栏位。\n当超过设定的最大值时，会返回第一个栏位。");
    public static final ConfigOptionList    HOTBAR_SWAP_OVERLAY_ALIGNMENT       = new ConfigOptionList  ("hotbarSwap | 背包显示位置", HudAlignment.BOTTOM_RIGHT, "设定显示背包内容物预览的位置。");
    public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_X        = new ConfigInteger     ("hotbarSwap | 背包显示X轴偏移", 4, "设定显示背包内容物预览的水平偏移量。");
    public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_Y        = new ConfigInteger     ("hotbarSwap | 背包显示Y轴偏移", 4, "设定显示背包内容物预览的垂直偏移量。");
    public static final ConfigInteger       ITEM_SWAP_DURABILITY_THRESHOLD      = new ConfigInteger     ("itemSwap | 工具耐久阈值", 20, 5, 10000, "启用§6工具防损坏§f后，低于该耐久的工具会被自动交换。");
    public static final ConfigBoolean       ITEM_USE_PACKET_CHECK_BYPASS        = new ConfigBoolean     ("itemUse | 物品使用校验", true, "绕过1.18.2中新增的距离/坐标检查。\n\n该检查破坏了“准确放置协议”，导致任何带有旋转（或其他属性）请求的方块放置都会变成幽灵方块。\n\n基本上没有必要禁用此功能。\n该检查在1.18.2之前根本不存在。");
    public static final ConfigInteger       MAP_PREVIEW_SIZE                    = new ConfigInteger     ("mapPreviewSize | 地图预览尺寸", 160, 16, 512, "使用§6地图预览§f时地图的尺寸。");
    public static final ConfigInteger       PERIODIC_ATTACK_INTERVAL            = new ConfigInteger     ("periodicAttack | 单击左键间隔", 20, 0, Integer.MAX_VALUE, "在§6周期性单击左键§f功能中，相邻两次单击的间隔时间。（单位gt）");
    public static final ConfigInteger       PERIODIC_USE_INTERVAL               = new ConfigInteger     ("periodicUse | 单击右键间隔", 20, 0, Integer.MAX_VALUE, "在§6周期性单击右键§f功能中，相邻两次单击的间隔时间。（单位gt）");
    public static final ConfigInteger       PERIODIC_HOLD_ATTACK_DURATION       = new ConfigInteger     ("periodicHoldAttack | 左键按住时间", 20, 0, Integer.MAX_VALUE, "这个数字是玩家持续按住左键的时间。（单位：游戏刻）");
    public static final ConfigInteger       PERIODIC_HOLD_ATTACK_INTERVAL       = new ConfigInteger     ("periodicHoldAttack | 左键按住间隔", 20, 0, Integer.MAX_VALUE, "这个数字是间隔多久按住一次。（单位：游戏刻）");
    public static final ConfigInteger       PERIODIC_HOLD_USE_DURATION          = new ConfigInteger     ("periodicHoldAttack | 右键按住时间", 20, 0, Integer.MAX_VALUE, "这个数字是玩家持续按住右键的时间。（单位：游戏刻）");
    public static final ConfigInteger       PERIODIC_HOLD_USE_INTERVAL          = new ConfigInteger     ("periodicHoldAttack | 右键按住间隔", 20, 0, Integer.MAX_VALUE, "这个数字是间隔多久按住一次。（单位：游戏刻）");
    public static final ConfigBoolean       PERMANENT_SNEAK_ALLOW_IN_GUIS       = new ConfigBoolean     ("permanentSneak | 界面下永久潜行", false, "开启此功能后即便你打开了游戏内的任何界面，你仍然会保持潜行的状态。");
    public static final ConfigInteger       PLACEMENT_GRID_SIZE                 = new ConfigInteger     ("placementGridSize | 放置间距大小", 3, 1, 1000, "当启用了§6放置间距限制§f功能时，设置放置间距的大小。\n按住该功能快捷键时滑动滚轮可以快速调整。");
    public static final ConfigInteger       PLACEMENT_LIMIT                     = new ConfigInteger     ("placementLimit | 放置数量限制", 3, 1, 10000, "当启用了§6放置数量限制§f功能时，设置每次放置的方块数量。\n按住该功能快捷键时滑动滚轮可以快速调整。");
    public static final ConfigOptionList    PLACEMENT_RESTRICTION_MODE          = new ConfigOptionList  ("placement | 放置模式限制", PlacementRestrictionMode.FACE, "使用的放置模式限制（可使用热键调节）");
    public static final ConfigBoolean       PLACEMENT_RESTRICTION_TIED_TO_FAST  = new ConfigBoolean     ("placement | 放置范围限制绑定", true, "启用此功能后，当开启/关闭§6方块快速放置§f时，§6放置范围限制§f将同步开启/关闭。");
    public static final ConfigBoolean       POTION_WARNING_BENEFICIAL_ONLY      = new ConfigBoolean     ("potion | 仅显示正面效果警报", true, "开启后仅显示正面效果的§6效果不足警报§f。");
    public static final ConfigInteger       POTION_WARNING_THRESHOLD            = new ConfigInteger     ("potionWarning | 效果警报阈值", 600, 1, 1000000, "当开启§6效果不足警报§f时，当身上的效果剩余时间小于此值时会对玩家发出提示。");
    public static final ConfigBoolean       REMEMBER_FLEXIBLE                   = new ConfigBoolean     ("rememberFlexible | 灵活放置记忆", true, "启用后，只要按住使用键（右键），\n灵活放置状态将从首个放置方块开始保持。\n无需持续按住所有灵活功能激活键即可快速放置同朝向方块。");
    public static final ConfigInteger       RENDER_LIMIT_ITEM                   = new ConfigInteger     ("renderLimitItem | 掉落物数量限制", -1, -1, 10000, "设定§6限制实体渲染§f功能对§e掉落物§f的最大渲染数量。\n填写-1代表不限制数量，即禁用此限制。");
    public static final ConfigInteger       RENDER_LIMIT_XP_ORB                 = new ConfigInteger     ("renderLimitXPOrb | 经验球数量限制", -1, -1, 10000, "设定§6限制实体渲染§f功能对§e经验球§f的最大渲染数量。\n填写-1代表不限制数量，即禁用此限制。");
    public static final ConfigInteger       SCULK_SENSOR_PULSE_LENGTH           = new ConfigInteger     ("sculkSensor | 潜声植物脉冲长度", 40, 0, 10000, "The pulse length for Sculk Sensors, if the 'tweakSculkPulseLength' tweak is enabled. \n# Sculk 传感器的脉冲长度，\n需启用 'tweakSculkPulseLength' 功能。");
    public static final ConfigBoolean       SHULKER_DISPLAY_BACKGROUND_COLOR    = new ConfigBoolean     ("shulkerDisplay | 彩色潜影盒预览", true, "将§6潜影盒预览§f功能预览界面的背景颜色设定为潜影盒的颜色。");
    public static final ConfigBoolean       SHULKER_DISPLAY_REQUIRE_SHIFT       = new ConfigBoolean     ("shulkerDisplay | 潜影盒预览", true, "潜影盒预览是否需要按住shift键");
    public static final ConfigBoolean       SLOT_SYNC_WORKAROUND                = new ConfigBoolean     ("slotSync | 同步物品槽", true, "开启此项可以放置在服务器上快速使用时，\n物品的堆叠数或耐久度显示与实际不符。");
    public static final ConfigBoolean       SLOT_SYNC_WORKAROUND_ALWAYS         = new ConfigBoolean     ("slotSync | 一直同步物品槽", false, "始终在按住使用键时启用槽位同步修复，\n不仅限于快速右键或快速放置场景。\n主要用于其他需要持续使用物品的模组，\n如Litematica的轻松放置模式。");
    public static final ConfigBoolean       SNAP_AIM_INDICATOR                  = new ConfigBoolean     ("snapAim | 瞄准辅助指示器", true, "是否显示瞄准辅助指示器。");
    public static final ConfigColor         SNAP_AIM_INDICATOR_COLOR            = new ConfigColor       ("snapAim | 瞄准辅助指示器颜色", "#603030FF", "§6瞄准辅助指示器§f的背景颜色。");
    public static final ConfigOptionList    SNAP_AIM_MODE                       = new ConfigOptionList  ("snapAimMode | 瞄准辅助模式", SnapAimMode.YAW, "切换瞄准辅助模式：水平角或俯仰角，或都显示。");
    public static final ConfigBoolean       SNAP_AIM_ONLY_CLOSE_TO_ANGLE        = new ConfigBoolean     ("snapAim | 预设角度内锁定视角", true, "启用后，仅当内部角度接近目标角度时才会触发快速瞄准\n具体阈值可通过“对齐视线 - XX阈值（snapAimThreshold）”设置");
    public static final ConfigBoolean       SNAP_AIM_PITCH_OVERSHOOT            = new ConfigBoolean     ("snapAim | 瞄准辅助翻转过限", false, "是否允许翻转角度大于正常的+/-90度 \n达到过限的+/-180度");
    public static final ConfigDouble        SNAP_AIM_PITCH_STEP                 = new ConfigDouble      ("snapAim | 瞄准辅助水平角模式", 12.5, 0, 90, "§6瞄准辅助§f显示翻转角度指示器。");
    public static final ConfigDouble        SNAP_AIM_THRESHOLD_PITCH            = new ConfigDouble      ("snapAim | 角度阈值（垂直方向）", 1.5, "对齐视线 - 俯仰(上下)阈值");
    public static final ConfigDouble        SNAP_AIM_THRESHOLD_YAW              = new ConfigDouble      ("snapAim | 角度阈值（水平方向）", 5.0, "对齐视线 - 偏航(左右)阈值");
    public static final ConfigDouble        SNAP_AIM_YAW_STEP                   = new ConfigDouble      ("snapAim | 瞄准辅助俯仰角模式", 45, 0, 360, "§6瞄准辅助§f显示旋转角度指示器。");
    public static final ConfigInteger       STRUCTURE_BLOCK_MAX_SIZE            = new ConfigInteger     ("structureBlock | 结构方块范围限制", 128, 1, 256, "修改§6更改结构方块范围上限§f功能结构方块能保存的最大范围。\n§6注意=在多人游戏中该功能可能不完全可用或完全不可用。§r");
    public static final ConfigString        TOOL_SWITCHABLE_SLOTS               = new ConfigString      ("toolSwitch | 工具选择范围", "1-9", "工具切换功能允许存放新工具的槽位列表。\n注意：工具切换也可切换至快捷栏已有对应工具的槽位，\n但仅会将新工具交换到此处指定的槽位。");
    public static final ConfigString        TOOL_SWITCH_IGNORED_SLOTS           = new ConfigString      ("toolSwitch | 工具选择忽略槽位", "", "工具切换功能在指定槽位激活时不生效的槽位列表");
    public static final ConfigBoolean       ZOOM_ADJUST_MOUSE_SENSITIVITY       = new ConfigBoolean     ("zoomAdjustMouse | 调整缩放灵敏度", true, "启用后，缩放功能激活时将降低鼠标灵敏度");
    public static final ConfigDouble        ZOOM_FOV                            = new ConfigDouble      ("zoomFov | 缩放时视角", 30, 0.01, 359.99, "设置使用望远镜时的视野角度。");

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
        public static final ConfigBoolean ELYTRA_FIX                        = new ConfigBoolean("elytraFix | 鞘翅修复", false, "由Earthcomputer和Nessie提供的鞘翅着陆修复。\n部署修复现已整合至原版，此功能仅影响着陆逻辑。");
        public static final ConfigBoolean MAC_HORIZONTAL_SCROLL             = new ConfigBoolean("macScroll | MAC修复", false, "Mac/OSX系统专用修复，应用与hscroll模组相同的调整，\n同时避免破坏基于malilib框架模组的滚动功能。");
        public static final ConfigBoolean RAVAGER_CLIENT_BLOCK_BREAK_FIX    = new ConfigBoolean("ravager | 劫掠兽幽灵方块修复", false, "修复劫掠兽客户端破坏方块导致的\n幽灵方块/方块同步异常问题");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                ELYTRA_FIX,
                MAC_HORIZONTAL_SCROLL,
                RAVAGER_CLIENT_BLOCK_BREAK_FIX
        );
    }

    public static class Lists
    {
        public static final ConfigOptionList BLOCK_TYPE_BREAK_RESTRICTION_LIST_TYPE = new ConfigOptionList("blockBreak | 方块破坏规则限制方式", ListType.BLACKLIST, "使用方块破坏规则时的限制方式");
        public static final ConfigStringList BLOCK_TYPE_BREAK_RESTRICTION_BLACKLIST = new ConfigStringList("blockBreak | 方块破坏规则黑名单", ImmutableList.of("minecraft:budding_amethyst"), "当启用方块破坏限制且列表类型为黑名单时，\n禁止破坏此处列出的方块类型");
        public static final ConfigStringList BLOCK_TYPE_BREAK_RESTRICTION_WHITELIST = new ConfigStringList("blockBreak | 方块破坏规则白名单", ImmutableList.of(), "当启用方块破坏限制且列表类型为白名单时，\n仅允许破坏此处列出的方块类型");
        public static final ConfigStringList CREATIVE_EXTRA_ITEMS               = new ConfigStringList("creativeExtra | 额外物品清单", ImmutableList.of("minecraft:command_block", "minecraft:chain_command_block", "minecraft:repeating_command_block", "minecraft:dragon_egg", "minecraft:structure_void", "minecraft:structure_block", "minecraft:structure_block{BlockEntityTag:{mode:\"SAVE\"}}", "minecraft:structure_block{BlockEntityTag:{mode:\"LOAD\"}}", "minecraft:structure_block{BlockEntityTag:{mode:\"CORNER\"}}"), "向创造模式物品栏添加自定义物品\n通过“列表”中的“创造模式额外物品（creativeExtraItems）”配置添加项\n注意：当前物品将添加至“运输类（物品最少的分组）”\n未来将支持按物品自定义分组");
        public static final ConfigOptionList ENTITY_TYPE_ATTACK_RESTRICTION_LIST_TYPE = new ConfigOptionList("entityAttack | 实体攻击规则限制方式", ListType.BLACKLIST, "使用实体攻击规则时的限制方式");
        public static final ConfigStringList ENTITY_TYPE_ATTACK_RESTRICTION_BLACKLIST = new ConfigStringList("entityAttack | 实体攻击规则黑名单", ImmutableList.of("minecraft:villager"), "当启用实体攻击限制且列表类型为黑名单时，\n禁止攻击此处列出的实体类型");
        public static final ConfigStringList ENTITY_TYPE_ATTACK_RESTRICTION_WHITELIST = new ConfigStringList("entityAttack | 实体攻击规则白名单", ImmutableList.of(), "当启用实体攻击限制且列表类型为白名单时，\n仅允许攻击此处列出的实体类型");
        public static final ConfigStringList ENTITY_WEAPON_MAPPING              = new ConfigStringList("entityWeapon | 武器切换规则", ImmutableList.of("<default> => minecraft:diamond_sword, minecraft:golden_sword, minecraft:iron_sword, minecraft:netherite_sword, minecraft:stone_sword, minecraft:wooden_sword", "minecraft:end_crystal, minecraft:item_frame, minecraft:glow_item_frame, minecraft:leash_knot => <ignore>", "minecraft:minecart, minecraft:chest_minecart, minecraft:furnace_minecart, minecraft:hopper_minecart, minecraft:hopper_minecart, minecraft:spawner_minecart, minecraft:tnt_minecart, minecraft:boat=> minecraft:diamond_axe, minecraft:golden_axe, minecraft:iron_axe, minecraft:netherite_axe, minecraft:stone_axe, minecraft:wooden_axe"), "“自动切换武器（tweakWeaponSwitch）”的武器映射配置。\n\n“<default>”用于未定义映射时的配置，\n“<ignore>”表示不能触发自动切换武器的配置。");
        public static final ConfigOptionList FAST_PLACEMENT_ITEM_LIST_TYPE      = new ConfigOptionList("fast | 快速放置限制方式", ListType.BLACKLIST, "用于限制§6快速放置方块§f的列表类型。");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_BLACKLIST      = new ConfigStringList("fast | 快速放置黑名单", ImmutableList.of("minecraft:ender_chest", "minecraft:white_shulker_box"), "当快速放置物品列表类型为黑名单时，\n禁止使用此处列出的物品进行快速放置");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_WHITELIST      = new ConfigStringList("fast | 快速放置白名单", ImmutableList.of(), "当快速放置物品列表类型为白名单时，\n仅允许使用此处列出的物品进行快速放置");
        public static final ConfigOptionList FAST_RIGHT_CLICK_BLOCK_LIST_TYPE   = new ConfigOptionList("fast | 快速右键方块限制方式", ListType.BLACKLIST, "用于限制§6右键快速点击§f的列表类型。");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_BLACKLIST   = new ConfigStringList("fast | 快速右键方块黑名单", ImmutableList.of("minecraft:chest", "minecraft:ender_chest", "minecraft:trapped_chest", "minecraft:white_shulker_box"), "当快速右键方块列表类型为黑名单时，\n禁止使用此处列出的方块进行快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_WHITELIST   = new ConfigStringList("fast | 快速右键方块白名单", ImmutableList.of(), "当快速右键方块列表类型为白名单时，\n仅允许使用此处列出的方块进行快速右键");
        public static final ConfigOptionList FAST_RIGHT_CLICK_ITEM_LIST_TYPE    = new ConfigOptionList("fast | 快速右键物品限制方式", ListType.NONE, "用于限制§6右键快速点击§f的列表类型。");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_BLACKLIST    = new ConfigStringList("fast | 快速右键物品黑名单", ImmutableList.of("minecraft:firework_rocket"), "当快速右键物品列表类型为黑名单时，\\\n禁止使用此处列出的物品进行快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_WHITELIST    = new ConfigStringList("fast | 快速右键物品白名单", ImmutableList.of("minecraft:bucket", "minecraft:water_bucket", "minecraft:lava_bucket", "minecraft:glass_bottle"), "当快速右键物品列表类型为白名单时，\n仅允许使用此处列出的物品进行快速右键");
        public static final ConfigStringList FLAT_WORLD_PRESETS                 = new ConfigStringList("flatWorld | 世界预设设置", ImmutableList.of("White Glass;1*minecraft:white_stained_glass;minecraft:plains;;minecraft:white_stained_glass", "Glass;1*minecraft:glass;minecraft:plains;;minecraft:glass"), "自定义超平坦世界预设格式：\n名称;方块字符串;生物群系;生成特征;图标物品\n方块字符串使用原版格式，例如：62*minecraft:dirt,minecraft:grass\n生物群系可使用注册名或数字ID\n图标物品格式示例：minecraft:iron_nugget");
        public static final ConfigOptionList HAND_RESTOCK_LIST_TYPE             = new ConfigOptionList("handRestock | 自动补货限制方式", ListType.NONE, "使用自动补货时的限制方式");
        public static final ConfigStringList HAND_RESTOCK_BLACKLIST             = new ConfigStringList("handRestock | 自动补货黑名单", ImmutableList.of("minecraft:bucket", "minecraft:lava_bucket", "minecraft:water_bucket"), "当自动补货列表类型为黑名单时，禁止对此处列出的物品进行补货");
        public static final ConfigStringList HAND_RESTOCK_WHITELIST             = new ConfigStringList("handRestock | 自动补货白名单", ImmutableList.of(), "当自动补货列表类型为白名单时，仅允许对此处列出的物品进行补货");
        public static final ConfigOptionList POTION_WARNING_LIST_TYPE           = new ConfigOptionList("potion | 效果不足警报限制方式", ListType.NONE, "用于限制§6效果不足警报§f的列表类型。。");
        public static final ConfigStringList POTION_WARNING_BLACKLIST           = new ConfigStringList("potion | 效果不足警报黑名单", ImmutableList.of("minecraft:hunger", "minecraft:mining_fatigue", "minecraft:nausea", "minecraft:poison", "minecraft:slowness", "minecraft:weakness"), "不会被提醒的药水效果列表。");
        public static final ConfigStringList POTION_WARNING_WHITELIST           = new ConfigStringList("potion | 效果不足警报白名单", ImmutableList.of("minecraft:fire_resistance", "minecraft:invisibility", "minecraft:water_breathing"), "会被提醒的药水效果列表。");
        public static final ConfigStringList REPAIR_MODE_SLOTS                  = new ConfigStringList("repair | 经验修补模式的应用范围", ImmutableList.of("mainhand", "offhand"), "设置修复模式生效的装备槽位\n有效值：\n 主手(mainhand)，副手(offhand)，\n 头部(head)，胸部(chest)，腿部(legs)，脚部(feet)");
        public static final ConfigStringList UNSTACKING_ITEMS                   = new ConfigStringList("unstacking | 不可堆叠保护列表", ImmutableList.of("minecraft:bucket", "minecraft:glass_bottle"), "功能§6不可堆叠物品保护§f所保护的物品。");

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
        public static final ConfigBooleanHotkeyed       DISABLE_ARMOR_STAND_RENDERING   = new ConfigBooleanHotkeyed("ArmorStand | 禁用盔甲架渲染",           false, "", "禁用所有盔甲架的实体渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_AXE_STRIPPING           = new ConfigBooleanHotkeyed("AxeStripping | 禁用斧头去皮",                  false, "", "禁用斧头对原木右键会使原木变为去皮原木的操作");
        public static final ConfigBooleanHotkeyed       DISABLE_BAT_SPAWNING            = new ConfigBooleanClient  ("disableBatSpawning",                   false, "", "在单人游戏中禁用蝙蝠生成");
        public static final ConfigBooleanHotkeyed       DISABLE_BEACON_BEAM_RENDERING   = new ConfigBooleanHotkeyed("BeaconBeam | 关闭信标光柱渲染",           false, "", "关闭信标光柱渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_BLOCK_BREAK_PARTICLES   = new ConfigBooleanHotkeyed("Block | 禁用方块破碎粒子",        false, "", "移除当方块破碎时产生的粒子效果。");
        public static final ConfigBooleanHotkeyed       DISABLE_DOUBLE_TAP_SPRINT       = new ConfigBooleanHotkeyed("DoubleTapSprint | 禁用双击疾跑",               false, "", "禁用后双击前进键时不会触发疾跑。");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_BAR                = new ConfigBooleanHotkeyed("BossBar | 禁用boss血条",                       false, "", "禁用boss血条的显示");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_FOG                = new ConfigBooleanHotkeyed("BossFog | 禁用Boss烟雾渲染",                       false, "", "移除boss所产生的烟雾效果。");
        public static final ConfigBooleanHotkeyed       DISABLE_CHUNK_RENDERING         = new ConfigBooleanHotkeyed("Chunk | 禁用区块渲染",                false, "", "停止区块的（重）渲染。此功能启用期间任何方块变化将不可见，\n需关闭后使用F3 + A刷新世界渲染。\n在存在大量无关紧要的方块变化场景中，可能有助于提升帧率。");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_ENTITY_UPDATES   = new ConfigBooleanHotkeyed("ClientEntity | 禁用实体更新",           false, "", "禁用客户端中除了玩家外所有实体的更新。\n当你需要去处理实体过多环境下的情况时，这可以降低客户端的渲染压力。");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_LIGHT_UPDATES    = new ConfigBooleanHotkeyed("Client | 禁用客户端光照更新",            false, "", "禁用客户端的所有光照更新。");
        public static final ConfigBooleanHotkeyed       DISABLE_CONSTANT_CHUNK_SAVING   = new ConfigBooleanHotkeyed("ChunkSaving | 禁用区块持续保存",           false, "", "禁用游戏每刻自动保存最多20个区块的功能\n（不影响常规自动保存周期）。");
        public static final ConfigBooleanHotkeyed       DISABLE_CREATIVE_INFESTED_BLOCKS= new ConfigBooleanHotkeyed("festedBlocks | 创造不可搜索虫蚀方块",    false, "", "从创造搜索清单中移除被虫蚀的石头方块");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_RENDERING      = new ConfigBooleanHotkeyed("DeadMob | 禁用怪物尸体渲染",              false, "", "不渲染死亡的怪物（生命值为0的实体），但这并不影响你与尸体交互。");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_TARGETING      = new ConfigBooleanHotkeyed("DeadMob | 禁用怪物尸体交互",              false, "", "阻止目标选择到已死亡实体\n避免攻击已死亡生物的问题");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_RENDERING        = new ConfigBooleanHotkeyed("Entity | 禁用实体渲染",               false, "", "禁用客户端中除了玩家外所有实体的渲染。\n当你需要去处理实体过多环境下的情况时，这可以极大地降低客户端的渲染压力。");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_TICKING          = new ConfigBooleanClient  ("disableEntityTicking",                 false, "", "禁止除玩家以外的所有实体运算。");
        public static final ConfigBooleanHotkeyed       DISABLE_FALLING_BLOCK_RENDER    = new ConfigBooleanHotkeyed("FallingBlock | 禁用掉落方块渲染",   false, "", "启用后，下落方块实体将完全不可见");
        public static final ConfigBooleanHotkeyed       DISABLE_FP_EFFECT_PARTICLES     = new ConfigBooleanHotkeyed("FirstPerson | 禁用第一人称粒子",    false, "", "在第一人称(从玩家本身)移除药剂的粒子效果");
        public static final ConfigBooleanHotkeyed       DISABLE_INVENTORY_EFFECTS       = new ConfigBooleanHotkeyed("InventoryEffect | 禁用背包中效果",      false, "", "移除了背包中药水、附魔效果的渲染。");
        public static final ConfigBooleanHotkeyed       DISABLE_ITEM_SWITCH_COOLDOWN    = new ConfigBooleanHotkeyed("ItemSwitch | 禁用装备动画",      false, "", "启用后，切换手持物品或使用物品时\n将不显示冷却/装备动画");
        public static final ConfigBooleanHotkeyed       DISABLE_MOB_SPAWNER_MOB_RENDER  = new ConfigBooleanHotkeyed("MobSpawnerMob | 禁用怪物生成渲染",        false, "", "移除了怪物生成时的实体渲染。");
        public static final ConfigBooleanHotkeyed       DISABLE_NAUSEA_EFFECT           = new ConfigBooleanHotkeyed("NauseaEffect | 禁用恶心效果",                  false, "", "禁用恶心所导致的视觉效果");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_FOG              = new ConfigBooleanHotkeyed("NetherFog | 禁用下界迷雾",                     false, "", "移除下界空中的迷雾。");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_PORTAL_SOUND     = new ConfigBooleanHotkeyed("NetherPortal | 禁用地狱门声音",             false, "", "禁用地狱门声音");
        public static final ConfigBooleanHotkeyed       DISABLE_OBSERVER                = new ConfigBooleanClient  ("disableObserver",                      false, "", "完全禁止侦测器被触发。");
        public static final ConfigBooleanHotkeyed       DISABLE_OFFHAND_RENDERING       = new ConfigBooleanHotkeyed("Offhand | 禁用副手渲染",              false, "", "禁用副手持有物品时对副手的渲染。");
        public static final ConfigBooleanHotkeyed       DISABLE_PARTICLES               = new ConfigBooleanHotkeyed("Particles | 禁用所有粒子",                     false, "", "禁用所有的粒子效果。");
        public static final ConfigBooleanHotkeyed       DISABLE_PORTAL_GUI_CLOSING      = new ConfigBooleanHotkeyed("PortalGuiClosing | 禁止传送门关闭GUI",              false, "", "启用后，身处下界传送门时仍可打开各类界面");
        public static final ConfigBooleanHotkeyed       DISABLE_RAIN_EFFECTS            = new ConfigBooleanHotkeyed("RainEffects | 禁用下雨效果",                   false, "", "禁用下雨时的视觉效果与声音。");
        public static final ConfigBooleanHotkeyed       DISABLE_RENDERING_SCAFFOLDING   = new ConfigBooleanHotkeyed("Renderingscaffold | 禁用脚手架渲染",          false, "", "禁用脚手架的渲染。");
        public static final ConfigBooleanHotkeyed       DISABLE_RENDER_DISTANCE_FOG     = new ConfigBooleanHotkeyed("Render | 禁用远处迷雾",             false, "", "禁用视距边缘的迷雾。");
        public static final ConfigBooleanHotkeyed       DISABLE_SCOREBOARD_RENDERING    = new ConfigBooleanHotkeyed("Scoreboard | 禁用计分板显示",           false, "", "禁用侧面的计分板显示");
        public static final ConfigBooleanHotkeyed       DISABLE_SHULKER_BOX_TOOLTIP     = new ConfigBooleanHotkeyed("SBoxTooltip | 禁用潜影盒原版显示",             false, "", "关闭潜影盒内容的原版文字显示");
        public static final ConfigBooleanHotkeyed       DISABLE_SHOVEL_PATHING          = new ConfigBooleanHotkeyed("ShovelPathing | 禁止制作土径",                 false, "", "用铲子不能将草方块等其他方块转换为土径块");
        public static final ConfigBooleanHotkeyed       DISABLE_SIGN_GUI                = new ConfigBooleanHotkeyed("SignGui | 禁用告示牌GUI",                       false, "", "禁用告示牌打开时的编辑界面。");
        public static final ConfigBooleanHotkeyed       DISABLE_SKY_DARKNESS            = new ConfigBooleanHotkeyed("SkyDarkness | 禁用天空黑暗",                   false, "", "禁用y=63以下的天空暗化效果\n（通过将阈值调整为世界底部以下2格实现）");
        public static final ConfigBooleanHotkeyed       DISABLE_SLIME_BLOCK_SLOWDOWN    = new ConfigBooleanHotkeyed("SlimeBlock | 禁用粘液块减速",            false, "", "消除了在粘液块上移动时减速效果。\n此功能来自nessie制作的usefulmod。");
        public static final ConfigBooleanHotkeyed       DISABLE_STATUS_EFFECT_HUD       = new ConfigBooleanHotkeyed("EffectHud | 禁用buff显示",               false, "", "禁用状态效果的HUD渲染(通常在屏幕的右上角)");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_RENDERING   = new ConfigBooleanHotkeyed("TileEntity | 禁用方块实体渲染",           false, "", "阻止所有的方块实体渲染。");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_TICKING     = new ConfigBooleanClient  ("disableTileEntityTicking",             false, "", "阻止所有的方块实体被加入运算。");
        public static final ConfigBooleanHotkeyed       DISABLE_VILLAGER_TRADE_LOCKING  = new ConfigBooleanClient  ("disableVillagerTradeLocking",          false, "", "通过同步增加配方使用次数与最大使用次数，\n防止村民交易被永久锁定");
        public static final ConfigBooleanHotkeyed       DISABLE_WALL_UNSPRINT           = new ConfigBooleanHotkeyed("WallUnsprint | 禁用墙壁刹车",                  false, "", "开启后在疾跑时撞上墙壁也不会停止疾跑状态。。");
        public static final ConfigBooleanHotkeyed       DISABLE_WORLD_VIEW_BOB          = new ConfigBooleanHotkeyed("WorldViewBob | 禁用视角摇晃",                  false, "", "禁用世界视角的晃动效果（不影响手持物品晃动）\n注意：安装Iris模组时此设置可能失效");

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
