package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

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

    @Override
    public Integer getValue() {
        return this.value;
    }
}
