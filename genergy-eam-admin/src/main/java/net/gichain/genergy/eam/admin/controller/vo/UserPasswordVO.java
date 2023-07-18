package net.gichain.genergy.eam.admin.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPasswordVO {
    @NotNull(message = "新密码不可以为空")
    private String newPwd;

    @NotNull(message = "确认密码不可以为空")
    private String confirmPwd;
}
