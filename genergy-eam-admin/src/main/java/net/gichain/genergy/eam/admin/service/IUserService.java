package net.gichain.genergy.eam.admin.service;

import net.gichain.genergy.eam.common.exceptions.BusinessException;
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
    boolean isExistByUserId(int id);

    boolean isExistByUsername(String username);

    boolean register(String username, String password) throws BusinessException;

    User login(String username, String password) throws BusinessException;

    boolean updatePassword(int id, String newPwd, String confirmPwd) throws BusinessException;
}
