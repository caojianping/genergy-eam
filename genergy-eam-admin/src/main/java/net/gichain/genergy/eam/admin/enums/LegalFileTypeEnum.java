package net.gichain.genergy.eam.admin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 法律文件枚举
 */
public enum LegalFileTypeEnum {
    /**
     * 并网合同
     */
    GRID_CONNECTION_CONTRACT(1),

    /**
     * 场地合同
     */
    SITE_CONTRACT(2),

    /**
     * 业主运营合同
     */
    OWNER_OPERATION_CONTRACT(3),

    /**
     * 建设与环评许可书
     */
    CONSTRUCTION_EIA_PERMIT(4),

    /**
     * 项目备案书
     */
    PROJECT_RECORD(5),

    /**
     * 上架项目合同书
     */
    PUTAWAY_PROJECT_CONTRACT(6);

    private final int value;

    LegalFileTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return this.value;
    }
}
