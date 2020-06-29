package net.gichain.genergy.eam.admin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 证件文件枚举
 */
public enum CertFileTypeEnum {
    /**
     * 营业执照
     */
    BUSINESS_LICENSE(1),

    /**
     * 机构代码证
     */
    ORGANIZATION_CODE_CERT(2),

    /**
     * 税务登记证
     */
    TAX_REGISTRATION_CERT(3),

    /**
     * 身份证正面
     */
    IDCARD_FRONT(4),

    /**
     * 身份证背面
     */
    IDCARD_BACK(5);

    private final int value;

    CertFileTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return this.value;
    }
}
