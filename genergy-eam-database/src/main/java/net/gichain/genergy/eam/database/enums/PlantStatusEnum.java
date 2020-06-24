package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

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

    @Override
    public Integer getValue() {
        return this.value;
    }
}
