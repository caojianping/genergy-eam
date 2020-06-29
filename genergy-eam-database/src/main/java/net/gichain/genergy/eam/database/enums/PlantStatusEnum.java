package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PlantStatusEnum implements IEnum<Integer> {
    /**
     * 禁用
     */
    DISABLED(0),

    /**
     * 启用
     */
    ENABLED(1);

    private final int value;

    PlantStatusEnum(int value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    public static PlantStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }

        PlantStatusEnum[] enums = PlantStatusEnum.values();
        for (PlantStatusEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }
}
