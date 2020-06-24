package net.gichain.genergy.eam.admin.controller.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String username;
    private Date createTime;
    private Date modifyTime;

    public static IPage<UserDTO> converFromUserPage(IPage<User> userPage) {
        return userPage.convert(user -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        });
    }
}
