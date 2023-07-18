package net.gichain.genergy.eam.common.util;

import java.math.BigDecimal;

public class MathUtils {
    /**
     * 四舍五入
     *
     * @param value     原数据值
     * @param precision 保留精度，及小数点后几位
     * @return
     */
    public static BigDecimal bigDecimalRound(BigDecimal value, int precision) {
        return value.setScale(precision, BigDecimal.ROUND_HALF_UP);
    }
}
