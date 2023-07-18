package net.gichain.genergy.eam.common;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.util.UUIDUtils;

import java.io.Serializable;

@Slf4j
public class JsonResult<T> implements Serializable {
    /**
     * code码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 跟踪调试
     */
    private String trace;

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }


    // 构造函数
    private JsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        this.trace = UUIDUtils.randomUUID();
    }

    // 构造函数
    private JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.trace = UUIDUtils.randomUUID();
    }

    // 构造函数
    private JsonResult(CodeEnum codeEnum, T data) {
        log.info(String.format("JsonResult: %s, %s, %s", codeEnum.getCode(), codeEnum.getMessage(), data));
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.data = data;
        this.trace = UUIDUtils.randomUUID();
    }


    // 处理成功
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(CodeEnum.SUCCESS, data);
    }

    // 处理失败
    public static <T> JsonResult<T> failure(T data) {
        return new JsonResult<T>(CodeEnum.FAILURE, data);
    }

    // 处理失败
    public static JsonResult failure(Integer code, String message) {
        return new JsonResult(code, message);
    }

    // 处理失败
    public static <T> JsonResult<T> failure(Integer code, String message, T data) {
        return new JsonResult<T>(code, message, data);
    }
}
