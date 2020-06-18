package net.gichain.genergy.eam.admin.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPasswordDTO {
    private int id;
    private String newPwd;
    private String confirmPwd;
}
