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
public class UserAddVO {
    @NotNull(message = "用户名不可以为空")
    private String username;

    @NotNull(message = "密码不可以为空")
    private String password;
}
