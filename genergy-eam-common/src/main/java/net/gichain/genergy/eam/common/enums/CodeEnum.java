package net.gichain.genergy.eam.common.enums;

import net.gichain.genergy.eam.common.IResponseResult;

public enum CodeEnum implements IResponseResult {
    SUCCESS(0, "操作成功"),

    AUTHORIZED_REQUIRED(100, "未授权，请您先登录"),
    TOKEN_ANALYSIS_ERROR(101, "Token解析异常"),
    INVALID_USERINFO(102, "无效的用户信息"),
    TOKEN_EXPIRED(103, "登录状态已经过期，请重新登录"),

    USERNAME_REQUIRED(200, "用户名称不可以为空"),
    PASSWORD_REQUIRED(201, "登录密码不可以为空"),
    NEW_PASSWORD_REQUIRED(202, "新密码不可以为空"),
    INVALID_PASSWORD(203, "密码格式不正确"),
    INCONFORMITY_PASSWORDS(204, "两次密码输入不一致"),
    USERNAME_REGISTERED(205, "用户已经注册"),
    USERNAME_OR_PASSWORD_ERROR(206, "用户名或密码不正确"),

    PLANT_INEXISTENCE(300, "此电站数据不存在"),

    ENERGY_INEXISTENCE(400, "此电站的发电量数据不存在"),

    ASSET_INEXISTENCE(500, "此资产数据不存在"),

    BUSINESS_ERROR(900, "业务异常"),
    TOEKN_ERROR(901, "token异常"),
    PARAMETER_ERROR(902, "参数异常"),

    UNKNOW_ERROR(997, "未知错误"),
    SYSTEM_ERROR(998, "系统异常"),
    FAILURE(999, "操作失败");

    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public IResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }
}

