package net.gichain.genergy.eam.common.exception;

import net.gichain.genergy.eam.common.enums.CodeEnum;

public class BusinessException extends BaseException {
    private static final CodeEnum DEFAULT_CODE_ENUM = CodeEnum.BUSINESS_ERROR;

    public BusinessException() {
        super(DEFAULT_CODE_ENUM);
    }

    public BusinessException(String message) {
        super(DEFAULT_CODE_ENUM.getCode(), message);
    }

    public BusinessException(CodeEnum codeEnum) {
        super(codeEnum);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(CodeEnum codeEnum, Throwable cause) {
        super(codeEnum.getMessage(), cause);
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
