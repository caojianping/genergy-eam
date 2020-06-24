package net.gichain.genergy.eam.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import net.gichain.genergy.eam.admin.controller.dto.UserDTO;
import net.gichain.genergy.eam.admin.controller.vo.UserAddVO;
import net.gichain.genergy.eam.admin.controller.vo.UserPasswordVO;
import net.gichain.genergy.eam.admin.controller.vo.UserUpdateVO;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.database.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cjp
 * @since 2020-06-13
 */
public interface IUserService extends IService<User> {
    boolean isExistById(int id);

    boolean isExistByUsername(String username);

    User login(UserAddVO userAddVO) throws BusinessException;

    IPage<UserDTO> pageUsers(int current, int size, String username);

    User getUserByUsername(String username);

    boolean addUser(UserAddVO userAddVO) throws BusinessException;

    boolean updateUser(UserUpdateVO userUpdateVO);

    boolean updatePassword(int id, UserPasswordVO userPasswordVO) throws BusinessException;

    boolean resetPassword(int id);

    boolean removeUser(int id);
}
