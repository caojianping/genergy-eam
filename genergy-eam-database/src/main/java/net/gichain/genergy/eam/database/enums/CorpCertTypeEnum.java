package net.gichain.genergy.eam.database.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

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

    @Override
    public Integer getValue() {
        return this.value;
    }
}
