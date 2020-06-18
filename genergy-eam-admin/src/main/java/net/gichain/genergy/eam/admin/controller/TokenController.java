package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.service.IUserService;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/token")
@RestController
public class TokenController {
    @Autowired
    private IUserService userService;

    @PostMapping("/status")
    @ResponseBody
    public boolean status() throws BusinessException {
        return true;
    }

    @PostMapping("/login")
    @ResponseBody
    public String refresh() throws BusinessException {
        return "";
    }
}
