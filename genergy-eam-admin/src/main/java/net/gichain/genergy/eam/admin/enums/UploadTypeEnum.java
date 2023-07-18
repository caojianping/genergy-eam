package net.gichain.genergy.eam.admin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 上传文件类型枚举
 */
public enum UploadTypeEnum {
    /**
     * 证件文件上传
     */
    CERT_UPLOAD(1),

    /**
     * 法律文件上传
     */
    LEGAL_UPLOAD(2),

    /**
     * 图片上传
     */
    IMG_UPLOAD(3);

    private final int value;

    UploadTypeEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return this.value;
    }
}
