package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.vo.UserAddVO;
import net.gichain.genergy.eam.admin.controller.vo.UserPasswordVO;
import net.gichain.genergy.eam.admin.service.IUserService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.common.util.JwtUtils;
import net.gichain.genergy.eam.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Validated
@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController extends BaseController {
    @Autowired
    private IUserService userService;

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

        HashMap<String, Object> claims = new HashMap<String, Object>(2) {
            {
                put("id", user.getId());
                put("username", user.getUsername());
            }
        };
        return JwtUtils.createToken(claims);
    }

    @TokenAnnotation
    @PostMapping("/logout")
    @ResponseBody
    public boolean logout() {
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

        HashMap<String, Object> claims = new HashMap<String, Object>(2) {
            {
                put("id", user.getId());
                put("username", user.getUsername());
            }
        };
        return JwtUtils.createToken(claims);
    }

    @TokenAnnotation
    @PostMapping("/setPassword")
    @ResponseBody
    public boolean setPassword(@RequestBody @Valid UserPasswordVO userPasswordVO) throws BusinessException, TokenException {
        Integer userId = this.getUserId();
        log.info(String.format("/user/setPassword userPasswordVO: %s", userPasswordVO.toString()));
        return userService.updatePassword(userId, userPasswordVO);
    }
}
