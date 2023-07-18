package net.gichain.genergy.eam.common.exception;

import net.gichain.genergy.eam.common.enums.CodeEnum;

public class ParameterException extends BaseException {
    private static final CodeEnum DEFAULT_CODE_ENUM = CodeEnum.PARAMETER_ERROR;

    public ParameterException() {
        super(DEFAULT_CODE_ENUM);
    }

    public ParameterException(String message) {
        super(DEFAULT_CODE_ENUM.getCode(), message);
    }

    public ParameterException(CodeEnum codeEnum) {
        super(codeEnum);
    }

    public ParameterException(int code, String message) {
        super(code, message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(CodeEnum codeEnum, Throwable cause) {
        super(codeEnum.getMessage(), cause);
    }

    public ParameterException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
