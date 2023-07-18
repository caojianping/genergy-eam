package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PlantTypeEnum implements IEnum<Integer> {
    /**
     * 分布式光伏
     */
    DISTRIBUTED_PHOTOVOLTAIC(0),

    /**
     * 户用光伏
     */
    HOUSEHOLD_PHOTOVOLTAIC(1),

    /**
     * 户用储能
     */
    HOUSEHOLD_STORED_ENERGY(2);

    private final int value;

    PlantTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    public static PlantTypeEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }

        PlantTypeEnum[] enums = PlantTypeEnum.values();
        for (PlantTypeEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }
}
