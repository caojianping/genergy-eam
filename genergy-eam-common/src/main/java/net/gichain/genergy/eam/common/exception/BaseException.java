package net.gichain.genergy.eam.common.exception;

import net.gichain.genergy.eam.common.enums.CodeEnum;

public class BaseException extends Exception {
    private Integer code = CodeEnum.SYSTEM_ERROR.getCode();

    protected BaseException() {
        super();
    }

    protected BaseException(String message) {
        super(message);
    }

    protected BaseException(CodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    protected BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    protected BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    protected BaseException(CodeEnum codeEnum, Throwable cause) {
        super(codeEnum.getMessage(), cause);
        this.code = codeEnum.getCode();
    }

    protected BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
