package fi.dy.masa.tweakeroo.config;

import java.util.List;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.hotkeys.KeybindSettings.Context;

public class Hotkeys
{
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_IN        = new ConfigHotkey("accurateInto | 精准方块放置 - 内部朝向",        "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活精确方块放置模式及其提示的键，\n用于将方块朝向放置到点击的方块面上");
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_REVERSE   = new ConfigHotkey("accurateReverse | 精准方块放置 - 反向朝向",     "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活精确方块放置模式及其提示的键，\n用于将方块放置到与原本方向相反的方向");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_COLUMN   = new ConfigHotkey("breaking | 破坏限制模式 - 列",     "",     "切换破坏限制模式为\"列\"\n限制范围：垂直于最初点击面的一列方块");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_DIAGONAL = new ConfigHotkey("breaking | 破坏限制模式 - 对角线(叉号)",   "",     "切换破坏限制模式为\"对角线\"\n限制范围：以最初破坏的方块为原点，点击面内的两条对角线的方块");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_FACE     = new ConfigHotkey("breaking | 破坏限制模式 - 点击面",       "",     "切换破坏限制模式为\"点击面\"\n限制范围：当前瞄准的与最初点击的表面的方向相同时，可以破坏当前瞄准的方块");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LAYER    = new ConfigHotkey("breaking | 破坏限制模式 - 层(固定y值)",      "",     "切换破坏限制模式为\"层\"\n限制范围：与最初破坏方块相同的y值的方块");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LINE     = new ConfigHotkey("breaking | 破坏限制模式 - 十字",       "",     "切换破坏限制模式为\"十字\"\n限制范围：以最初破坏的方块为原点，点击面内的两条坐标轴的方块");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_PLANE    = new ConfigHotkey("breaking | 破坏限制模式 - 平面",      "",     "切换破坏限制模式为\"平面\"\n限制范围：最初破坏方块的点击面内的方块\n  破坏第一个方块瞄准的顶面或底面时表现为固定y值破坏范围，\n  瞄准侧面则表现为固定x或z值的范围。");
    public static final ConfigHotkey COPY_SIGN_TEXT                     = new ConfigHotkey("copySignText | 复制告示牌文本",                      "",     "复制已放置告示牌的文本内容\n可与\"告示牌文本复制（tweakSignCopy）\"功能配合使用");
    public static final ConfigHotkey ELYTRA_CAMERA                      = new ConfigHotkey("elytraCamera | 鞘翅飞行视角",                      "",     "锁定玩家实际视角方向，允许通过输入设备（鼠标）\n单独控制仅用于渲染的「相机视角」\n专为鞘翅飞行时自由观察周围环境设计");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ADJACENT  = new ConfigHotkey("flexible | 灵活方块放置 - 相邻位置",    "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活精确方块放置模式及其提示的键，\n用于将方块放置在相邻的位置");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_OFFSET    = new ConfigHotkey("flexible | 灵活方块放置 - 偏移位置",      "LEFT_CONTROL", KeybindSettings.PRESS_ALLOWEXTRA, "激活精确方块放置模式及其提示的键，\n用于将方块放置在\"对边\"位置");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ROTATION  = new ConfigHotkey("flexible | 灵活方块放置 - 旋转朝向",    "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "激活精确方块放置模式及其提示的键，\n用于调整放置方块的旋转方向/朝向");
    public static final ConfigHotkey FLY_PRESET_1                       = new ConfigHotkey("flyPreset1 | 飞行预设1",                        "",     "切换至飞行速度预设方案1");
    public static final ConfigHotkey FLY_PRESET_2                       = new ConfigHotkey("flyPreset2 | 飞行预设2",                        "",     "切换至飞行速度预设方案2");
    public static final ConfigHotkey FLY_PRESET_3                       = new ConfigHotkey("flyPreset3 | 飞行预设3",                        "",     "切换至飞行速度预设方案3");
    public static final ConfigHotkey FLY_PRESET_4                       = new ConfigHotkey("flyPreset4 | 飞行预设4",                        "",     "切换至飞行速度预设方案4");
    public static final ConfigHotkey FREE_CAMERA_PLAYER_INPUTS          = new ConfigHotkey("freeCam | 灵魂出窍 - 玩家左右键",            "",     "开关\"通用\"中的\"灵魂出窍 - 玩家左右键（freeCameraPlayerInputs）\"选项");
    public static final ConfigHotkey FREE_CAMERA_PLAYER_MOVEMENT        = new ConfigHotkey("freeCamPlayer | 灵魂出窍 - 本体移动",          "",     "开关\"通用\"中的\"灵魂出窍 - 本体移动（freeCameraPlayerMovement）\"选项");
    public static final ConfigHotkey HOTBAR_SCROLL                      = new ConfigHotkey("hotbarScroll | 快捷栏滚动",                      "",     KeybindSettings.RELEASE_ALLOW_EXTRA, "按住此键可通过背包行滚动切换快捷栏");
    public static final ConfigHotkey HOTBAR_SWAP_BASE                   = new ConfigHotkey("hotbarSwapBase | 快捷栏交换 - 基础按键",                    "",     KeybindSettings.PRESS_ALLOWEXTRA, "显示快捷栏/背包交换界面的基础按键");
    public static final ConfigHotkey HOTBAR_SWAP_1                      = new ConfigHotkey("hotbarSwap1 | 快捷栏交换 - 第一行",                       "",     "将快捷栏与背包第一行（最顶行）物品交换");
    public static final ConfigHotkey HOTBAR_SWAP_2                      = new ConfigHotkey("hotbarSwap2 | 快捷栏交换 - 第二行",                       "",     "将快捷栏与背包第二行（中间行）物品交换");
    public static final ConfigHotkey HOTBAR_SWAP_3                      = new ConfigHotkey("hotbarSwap3 | 快捷栏交换 - 第三行",                       "",     "将快捷栏与背包第三行（最底行）物品交换");
    public static final ConfigHotkey INVENTORY_PREVIEW                  = new ConfigHotkey("§6inventoryPreview | 容器预览 - 快捷键§f",                  "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "激活容器预览功能的快捷键");
    public static final ConfigHotkey OPEN_CONFIG_GUI                    = new ConfigHotkey("openConfigGui | 打开配置界面",                     "X,C",  "打开游戏内配置界面的快捷键");
    public static final ConfigHotkey PLACEMENT_Y_MIRROR                 = new ConfigHotkey("placementYMirror | Y轴镜像放置(台阶、楼梯等)",                  "",     KeybindSettings.PRESS_ALLOWEXTRA, "在目标方块内部镜像Y轴坐标进行放置(作用于台阶、楼梯等)");
    public static final ConfigHotkey PLAYER_INVENTORY_PEEK              = new ConfigHotkey("§6InventoryPeek | 玩家背包预览§f",               "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活玩家背包预览功能的快捷键");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_COLUMN  = new ConfigHotkey("fastPlacement | 放置限制模式 - 列(法线方向)",    "Z,3",  "切换放置限制模式为列模式(法线方向)\n只能在\"最初点击的方块表面\"法线方向上放置");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_DIAGONAL= new ConfigHotkey("fastPlacement | 放置限制模式 - 对角线(叉号方向)",  "Z,5",  "切换放置限制模式为对角线模式(叉号方向)\n只能在\"最初放置的方块与其点击表面\"为交点和所在平面的\"两条对角线\"上放置\n§6注意：此功能无法凭空放置方块。§f");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_FACE    = new ConfigHotkey("fastPlacement | 放置限制模式 - 点击面(固定方向表面)",      "Z,2",  "切换放置限制模式为点击面模式(固定方向表面)\n只能在\"最初点击的方块表面\"相同方向的表面放置");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LAYER   = new ConfigHotkey("fastPlacement | 放置限制模式 - 层状(固定y值)",     "Z,6",  "切换放置限制模式为层状模式(固定y值)\n只能在\"最初放置的方块\"相同的y高度放置");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LINE    = new ConfigHotkey("fastPlacement | 放置限制模式 - 十字",      "Z,4",  "切换放置限制模式为十字模式(十字方向)\n只能在\"最初放置的方块与其点击表面\"为交点和所在平面的\"两条垂线\"上放置");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_PLANE   = new ConfigHotkey("fastPlacement | 放置限制模式 - 平面",     "Z,1",  "切换放置限制模式为平面模式\n只能在\"最初放置的方块\"相同的y高度放置");
    public static final ConfigHotkey SIT_DOWN_NEARBY_PETS               = new ConfigHotkey("sitDown | 附近宠物坐下",                 "",     "使附近所有宠物进入坐下状态");
    public static final ConfigHotkey SKIP_ALL_RENDERING                 = new ConfigHotkey("skipAllRender | 跳过全部渲染",                  "",     "切换是否跳过所有渲染过程");
    public static final ConfigHotkey SKIP_WORLD_RENDERING               = new ConfigHotkey("skipWorldRender | 跳过世界渲染",                "",     "切换是否跳过世界渲染");
    public static final ConfigHotkey STAND_UP_NEARBY_PETS               = new ConfigHotkey("standUp | 附近宠物站立",                 "",     "使附近所有宠物恢复站立状态");
    public static final ConfigHotkey SWAP_ELYTRA_CHESTPLATE             = new ConfigHotkey("swapElytra | 切换鞘翅与胸甲",              "",     "在胸甲槽位的鞘翅与胸甲之间快速切换");
    public static final ConfigHotkey TOGGLE_CARPET_AP_PROTOCOL          = new ConfigHotkey("toggleCarpet | 开关 - 精准放置协议", "", "切换\"通用\"中的\"精准放置协议（accuratePlacementProtocol）\"选项状态");
    public static final ConfigHotkey TOGGLE_GRAB_CURSOR                 = new ConfigHotkey("toggleGrabCursor | 开关 - 光标锁定",                  "",     "根据当前状态锁定或释放鼠标光标");
    public static final ConfigHotkey TOOL_PICK                          = new ConfigHotkey("toolPick | 工具切换",                          "",     "自动切换为适合破坏目标方块的有效工具");
    public static final ConfigHotkey WRITE_MAPS_AS_IMAGES               = new ConfigHotkey("writeMaps | 导出地图为图片",                 "",     "将所有当前可用的地图作为图像写入到 \n'config/tweakeroo/map images/<world name>/' 目录");
    public static final ConfigHotkey ZOOM_ACTIVATE                      = new ConfigHotkey("zoomActivate | 缩放激活",                      "",     KeybindSettings.create(Context.INGAME, KeyAction.BOTH, true, false, false, false, false), "缩放激活快捷键\n由 Andrew54757 在 TweakFork 下编写");

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