package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.UserDTO;
import net.gichain.genergy.eam.admin.controller.vo.UserAddVO;
import net.gichain.genergy.eam.admin.controller.vo.UserPasswordVO;
import net.gichain.genergy.eam.admin.controller.vo.UserUpdateVO;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.PasswordUtils;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.database.entity.User;
import net.gichain.genergy.eam.database.mapper.UserMapper;
import net.gichain.genergy.eam.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-13
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    /**
     * 判断用户是否存在（根据编号）
     *
     * @param id 编号
     * @return
     */
    @Override
    public boolean isExistById(int id) {
        User user = this.getById(id);
        return user != null;
    }

    /**
     * 判断用户是否存在（根据用户名）
     *
     * @param username 用户名
     * @return
     */
    @Override
    public boolean isExistByUsername(String username) {
        User user = this.getUserByUsername(username);
        return user != null;
    }

    /**
     * 用户登录
     *
     * @param userAddVO 添加用户VO数据
     * @return
     * @throws BusinessException
     */
    @Override
    public User login(UserAddVO userAddVO) throws BusinessException {
        String username = userAddVO.getUsername();
        String password = userAddVO.getPassword();
        if (StringUtils.isNullOrEmpty(username)) {
            throw new BusinessException(CodeEnum.USERNAME_REQUIRED);
        }
        if (StringUtils.isNullOrEmpty(password)) {
            throw new BusinessException(CodeEnum.PASSWORD_REQUIRED);
        }

        // 验证用户是否已经存在
        User user = this.getUserByUsername(username);
        if (user == null) {
            throw new BusinessException(CodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        // 加密登录密码，同原始密码作比对，返回比对结果
        String originPwd = user.getPassword();
        String encryptPwd = PasswordUtils.MD5Encrypt(password + user.getSalt());
        if (!encryptPwd.equals(originPwd)) {
            throw new BusinessException(CodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return user;
    }

    /**
     * 获取用户分页列表
     *
     * @param current  当前页码
     * @param size     分页尺寸
     * @param username 用户名
     * @return
     */
    @Override
    public IPage<UserDTO> pageUsers(int current, int size, String username) {
        if (current <= 0) {
            current = 1;
        }
        if (size > 1000) {
            size = 1000;
        }

        Page<User> pageParameters = new Page<User>(current, size);
        QueryWrapper<User> queryParameters = new QueryWrapper<User>();
        if (!StringUtils.isNullOrEmpty(username)) {
            queryParameters = queryParameters.like("username", username);
        }

        IPage<User> pageResult = this.page(pageParameters, queryParameters);
        return UserDTO.converFromUserPage(pageResult);
    }

    /**
     * 获取用户信息（根据用户名）
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username", username);
        return this.getOne(wrapper);
    }

    /**
     * 添加用户
     *
     * @param userAddVO 添加用户VO数据
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean addUser(UserAddVO userAddVO) throws BusinessException {
        String username = userAddVO.getUsername();
        String password = userAddVO.getPassword();
        if (StringUtils.isNullOrEmpty(username)) {
            throw new BusinessException(CodeEnum.USERNAME_REQUIRED);
        }
        if (StringUtils.isNullOrEmpty(password)) {
            throw new BusinessException(CodeEnum.PASSWORD_REQUIRED);
        }
//        if (Pattern.matches(RegexConstants.REGEX_PASSWORD, password))
//            throw new BusinessException(CodeEnum.INVALID_PASSWORD);

        // 验证用户是否已经注册过
        boolean isRegistered = this.isExistByUsername(username);
        if (isRegistered) {
            throw new BusinessException(CodeEnum.USERNAME_REGISTERED);
        }

        // 生成盐、加密密码
        String salt = PasswordUtils.createSalt(32);
        String encryptPwd = PasswordUtils.MD5Encrypt(password + salt);
        log.info(String.format("UserServiceImpl.register：salt=%s, encryptPwd=%s", salt, encryptPwd));

        // 创建新用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptPwd);
        user.setSalt(salt);
        user.setCreateTime(new Date());
        user.setDeleted(false);
        return this.save(user);
    }

    /**
     * 更新用户
     *
     * @param userUpdateVO 更新用户VO数据
     * @return
     */
    @Override
    public boolean updateUser(UserUpdateVO userUpdateVO) {
        User user = new User();
        user.setId(userUpdateVO.getId());
        user.setUsername(userUpdateVO.getUsername());
        user.setPassword(userUpdateVO.getPassword());
        return this.updateById(user);
    }

    /**
     * 更新密码
     *
     * @param userPasswordVO 更新密码VO数据
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean updatePassword(int id, UserPasswordVO userPasswordVO) throws BusinessException {
        String newPwd = userPasswordVO.getNewPwd();
        String confirmPwd = userPasswordVO.getConfirmPwd();
        if (StringUtils.isNullOrEmpty(newPwd)) {
            throw new BusinessException(CodeEnum.NEW_PASSWORD_REQUIRED);
        }
//        if (Pattern.matches(RegexConstants.REGEX_PASSWORD, newPwd)) {
//            throw new BusinessException(CodeEnum.INVALID_PASSWORD);
//        }
        if (newPwd.equals(confirmPwd)) {
            throw new BusinessException(CodeEnum.INCONFORMITY_PASSWORDS);
        }

        // 生成新盐、加密新密码
        String salt = PasswordUtils.createSalt(32);
        String encryptPwd = PasswordUtils.MD5Encrypt(newPwd + salt);

        // 更新用户信息
        User user = new User();
        user.setId(id);
        user.setPassword(encryptPwd);
        user.setSalt(salt);
        user.setModifyTime(new Date());
        return this.updateById(user);
    }

    /**
     * 重置密码
     *
     * @param id 编号
     * @return
     */
    @Override
    public boolean resetPassword(int id) {
        // 生成新盐、加密重置密码
        String salt = PasswordUtils.createSalt(32);
        String encryptPwd = PasswordUtils.MD5Encrypt("1234567a" + salt);

        // 更新用户信息
        User user = new User();
        user.setId(id);
        user.setPassword(encryptPwd);
        user.setSalt(salt);
        user.setModifyTime(new Date());
        return this.updateById(user);
    }

    /**
     * 移除用户
     *
     * @param id 编号
     * @return
     */
    @Override
    public boolean removeUser(int id) {
        User user = new User();
        user.setId(id);
        user.setModifyTime(new Date());
        user.setDeleted(true);
        return this.updateById(user);
    }
}
