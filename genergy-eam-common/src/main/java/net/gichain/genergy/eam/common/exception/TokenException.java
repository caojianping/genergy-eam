package net.gichain.genergy.eam.common.exception;

import net.gichain.genergy.eam.common.enums.CodeEnum;

public class TokenException extends BaseException {
    private static final CodeEnum DEFAULT_CODE_ENUM = CodeEnum.TOEKN_ERROR;

    public TokenException() {
        super(DEFAULT_CODE_ENUM);
    }

    public TokenException(String message) {
        super(DEFAULT_CODE_ENUM.getCode(), message);
    }

    public TokenException(CodeEnum codeEnum) {
        super(codeEnum);
    }

    public TokenException(int code, String message) {
        super(code, message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(CodeEnum codeEnum, Throwable cause) {
        super(codeEnum.getMessage(), cause);
    }

    public TokenException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
