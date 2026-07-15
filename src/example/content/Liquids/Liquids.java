/**
 * 定义自定义液体的示例类（示例用途）。
 * 说明：此类定义了示例液体 `Thinner` 与 `neoplasm`，用于演示如何注册自定义液体。
 */
package example.content.Liquids;

import arc.graphics.*;
import mindustry.content.StatusEffects;
import mindustry.type.*;

/**
 * 定义自定义液体类，用于在游戏中注册和加载新液体。
 */
public class Liquids{
    /**
     * 自定义液体实例。此液体将在 load() 方法中初始化。
     */
    public static Liquid neoplasm;
    public static Liquid Thinner;

    /**
     * 加载并注册所有自定义液体。
     */
    public static void load(){

         Thinner = new Liquid("Thinner", Color.valueOf("596ab8")){{
            heatCapacity = 0.4f;
            effect = StatusEffects.wet;
            boilPoint = 0.5f;
            gasColor = Color.grays(0.9f);
            alwaysUnlocked = true;
        }};


        // 创建一个新的 CellLiquid 实例，代表一个具有细胞/液体性质的自定义液体
        neoplasm = new CellLiquid("neoplasm", Color.valueOf("c33e2b")){{
            // 热容决定液体吸收热量的能力
            heatCapacity = 0.4f;
            // 默认温度，用于液体温度相关效果
            temperature = 1145;
            // 粘度决定流动速度，值越高流动越慢
            viscosity = 0.85f;
            // 不可燃
            flammability = 0f;
            // 禁止在地面形成水坑
            capPuddles = true;
            // 传播目标液体，用于液体交互时的扩散行为
            spreadTarget = Liquids.Thinner;
            // 是否能够穿过方块
            moveThroughBlocks = true;
            // 不会被焚烧消耗
            incinerable = true;
            // 不与方块发生反应
            blockReactive = false;

            // 颜色渐变起始色
            colorFrom = Color.valueOf("e8803f");
            // 颜色渐变结束色
            colorTo = Color.valueOf("8c1225");
        }};
    }
}
