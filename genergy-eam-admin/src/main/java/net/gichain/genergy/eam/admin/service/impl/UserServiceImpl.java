package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.constants.RegexConstant;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import net.gichain.genergy.eam.common.util.PasswordUtils;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.database.entity.User;
import net.gichain.genergy.eam.database.mapper.UserMapper;
import net.gichain.genergy.eam.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

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
     * 获取用户信息（根据用户名）
     *
     * @param username 用户名
     * @return
     */
    private User getUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username", username);
        return this.baseMapper.selectOne(wrapper);
    }

    /**
     * 判断用户是否存在（根据用户编号）
     *
     * @param id 用户编号
     * @return
     */
    @Override
    public boolean isExistByUserId(int id) {
        User user = this.baseMapper.selectById(id);
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
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean register(String username, String password) throws BusinessException {
        if (StringUtils.isNullOrEmpty(username)) {
            throw new BusinessException(CodeEnum.USERNAME_REQUIRED);
        }
        if (StringUtils.isNullOrEmpty(password)) {
            throw new BusinessException(CodeEnum.PASSWORD_REQUIRED);
        }
//        if (Pattern.matches(RegexConstant.REGEX_PASSWORD, password))
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
        user.setCreateTime(LocalDateTime.now());
        user.setIsDelete(false);
        return this.baseMapper.insert(user) > 0;
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws BusinessException
     */
    @Override
    public User login(String username, String password) throws BusinessException {
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
     * 更新密码
     *
     * @param id         用户编号
     * @param newPwd     新密码
     * @param confirmPwd 确认密码
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean updatePassword(int id, String newPwd, String confirmPwd) throws BusinessException {
        if (StringUtils.isNullOrEmpty(newPwd)) {
            throw new BusinessException(CodeEnum.NEW_PASSWORD_REQUIRED);
        }
//        if (Pattern.matches(RegexConstant.REGEX_PASSWORD, newPwd)) {
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
        user.setModifyTime(LocalDateTime.now());
        return this.baseMapper.updateById(user) > 0;
    }
}
