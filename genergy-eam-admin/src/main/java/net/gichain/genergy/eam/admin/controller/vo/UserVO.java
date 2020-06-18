package net.gichain.genergy.eam.admin.controller.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserVO {
    private int id;
    private String username;

    public static UserVO convertFromUser(User user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public static List<UserVO> convertFromUserList(List<User> users) {
        List<UserVO> list = new ArrayList<>();
        for (User user : users) {
            UserVO temp = new UserVO();
            BeanUtils.copyProperties(user, temp);
            list.add(temp);
        }
        return list;
    }

    public static IPage<UserVO> converFromUserPage(IPage<User> page) {
        return page.convert(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        });
    }
}
