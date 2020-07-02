package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.vo.UserAddVO;
import net.gichain.genergy.eam.admin.controller.vo.UserPasswordVO;
import net.gichain.genergy.eam.admin.service.IRedisService;
import net.gichain.genergy.eam.admin.service.IUserService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.admin.util.JwtUtils;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import net.gichain.genergy.eam.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController extends BaseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody @Valid UserAddVO userAddVO) throws BusinessException {
        log.info(String.format("/user/register userAddVO: %s", userAddVO.toString()));
        return userService.addUser(userAddVO);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody @Valid UserAddVO userAddVO) throws BusinessException {
        log.info(String.format("/user/login userAddVO: %s", userAddVO.toString()));
        User user = userService.login(userAddVO);
        return handleToken(user.getId(), user.getUsername());
    }

    @TokenAnnotation
    @GetMapping("/logout")
    @ResponseBody
    public boolean logout() throws TokenException {
        Integer userId = this.getUserId();
        String uuid = this.getUUID();
        redisService.removeTokenCache(userId, uuid);
        return true;
    }

    @TokenAnnotation
    @PostMapping("/token/status")
    @ResponseBody
    public boolean getTokenStatus() throws TokenException {
        return !this.isExpired();
    }

    @TokenAnnotation
    @PostMapping("/token/refresh")
    @ResponseBody
    public String refreshToken() throws TokenException {
        Integer userId = this.getUserId();
        User user = userService.getById(userId);
        if (user == null) {
            throw new TokenException(CodeEnum.INVALID_USERINFO);
        }

        return handleToken(userId, user.getUsername());
    }

    @TokenAnnotation
    @PostMapping("/setPassword")
    @ResponseBody
    public boolean setPassword(@RequestBody @Valid UserPasswordVO userPasswordVO) throws BusinessException, TokenException {
        Integer userId = this.getUserId();
        log.info(String.format("/user/setPassword userPasswordVO: %s", userPasswordVO.toString()));
        return userService.updatePassword(userId, userPasswordVO);
    }

    /**
     * 处理token
     *
     * @param id       编号
     * @param username 用户名
     * @return
     */
    private String handleToken(int id, String username) {
        // 缓存token、创建token
        String uuid = UUIDUtils.randomWords(4, false);
        redisService.addTokenCache(id, uuid);
        return JwtUtils.createToken(id, username, uuid);
    }
}
