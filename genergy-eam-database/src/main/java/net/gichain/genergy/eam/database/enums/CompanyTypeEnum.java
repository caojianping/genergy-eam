package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CompanyTypeEnum implements IEnum<Integer> {
    /**
     * 国有企业
     */
    STATE_OWNED_COMPANY(0),

    /**
     * 集体企业
     */
    COLLECTIVELY_OWNED_COMPANY(1),

    /**
     * 私营企业
     */
    PRIVATE_COMPANY(2),

    /**
     * 联营企业
     */
    OFFILIATED_COMPANY(3),

    /**
     * 股份制企业
     */
    CORPORATE_COMPANY(4);

    private final int value;

    CompanyTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    public static CompanyTypeEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }

        CompanyTypeEnum[] enums = CompanyTypeEnum.values();
        for (CompanyTypeEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }
}
