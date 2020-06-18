package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.UserDTO;
import net.gichain.genergy.eam.admin.service.IUserService;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import net.gichain.genergy.eam.common.util.JwtUtils;
import net.gichain.genergy.eam.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController {
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody UserDTO userDTO) throws BusinessException {
        log.info(String.format("/user/register args: %s", userDTO.toString()));
        return userService.register(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserDTO userDTO) throws BusinessException {
        log.info(String.format("/user/login args: %s", userDTO.toString()));
        User user = userService.login(userDTO.getUsername(), userDTO.getPassword());
        Map<String, Object> claims = new HashMap<>(1);
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        return JwtUtils.createToken(claims);
    }

    @PostMapping("/logout")
    @ResponseBody
    public boolean logout() {
        return true;
    }
}
