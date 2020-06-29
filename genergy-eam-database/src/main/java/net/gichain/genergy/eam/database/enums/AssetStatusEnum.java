package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AssetStatusEnum implements IEnum<Integer> {
    /**
     * 已创建/已保存/未提交
     */
    CREATED(0),

    /**
     * 已提交/未审核
     */
    SUBMITTED(10),

    /**
     * 已审核
     */
    AUDITED(20);

    private final int value;

    AssetStatusEnum(int value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    public static AssetStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }

        AssetStatusEnum[] enums = AssetStatusEnum.values();
        for (AssetStatusEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }
}
