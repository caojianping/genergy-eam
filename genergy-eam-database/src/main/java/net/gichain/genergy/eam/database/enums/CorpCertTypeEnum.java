package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CorpCertTypeEnum implements IEnum<Integer> {
    /**
     * 身份证
     */
    IDCARD(0),

    /**
     * 护照
     */
    PASSPORT(1),

    /**
     * 军官证
     */
    MILITARY_OFFICER(2);

    private final int value;

    CorpCertTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    public static CorpCertTypeEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }

        CorpCertTypeEnum[] enums = CorpCertTypeEnum.values();
        for (CorpCertTypeEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }
}
