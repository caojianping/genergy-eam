package net.gichain.genergy.eam.common.enums;

import net.gichain.genergy.eam.common.IResponseResult;

public enum CodeEnum implements IResponseResult {
    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),

    AUTHORIZED_REQUIRED(401, "未授权，请您先登录"),
    TOKEN_EXPIRED(402, "登录状态已经过期，请重新登录"),
    TOKEN_ANALYSIS_ERROR(403, "Token解析异常"),

    INVALID_USERINFO(420, "无效的用户信息"),
    USERNAME_REQUIRED(421, "用户名称不可以为空"),
    PASSWORD_REQUIRED(422, "登录密码不可以为空"),
    NEW_PASSWORD_REQUIRED(423, "新密码不可以为空"),
    INVALID_PASSWORD(424, "密码格式不正确"),
    INCONFORMITY_PASSWORDS(425, "两次密码输入不一致"),
    USERNAME_REGISTERED(426, "用户已经注册"),
    USERNAME_OR_PASSWORD_ERROR(427, "用户名或密码不正确"),

    PLANT_INEXISTENCE(500, "此电站数据不存在"),
    PLANT_ID_REQUIRED(501, "电站编号不可以为空"),

    ASSET_INEXISTENCE(530, "此资产数据不存在"),
    ASSET_AUDIT_SCOPE(531, "未满足资产操作的限制要求（只支持审核操作）"),
    ASSET_AUDIT_PRECONDITION(532, "未满足资产审核的前提条件（资产必须已提交）"),

    ENERGY_INEXISTENCE(560, "此电站的发电量数据不存在"),

    FILE_REQUIRED(600, "文件不能为空"),
    FILE_ERROR(601, "文件上传异常"),

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

