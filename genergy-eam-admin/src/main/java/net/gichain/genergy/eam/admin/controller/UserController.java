package net.gichain.genergy.eam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.UserDTO;
import net.gichain.genergy.eam.admin.controller.vo.UserAddVO;
import net.gichain.genergy.eam.admin.controller.vo.UserUpdateVO;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @TokenAnnotation
    @GetMapping("/page/{current}/{size}")
    @ResponseBody
    public IPage<UserDTO> pageUsers(
            @PathVariable(name = "current") int current,
            @PathVariable(name = "size") int size,
            @RequestParam(required = false) String username
    ) {
        log.info(String.format("/user/page current,size,username: %d %d %s", current, size, username));
        return userService.pageUsers(current, size, username);
    }

    @TokenAnnotation
    @PostMapping("/add")
    @ResponseBody
    public boolean addUser(@RequestBody UserAddVO userAddVO) throws BusinessException {
        log.info(String.format("/user/add userAddVO: %s", userAddVO.toString()));
        return userService.addUser(userAddVO);
    }

    @TokenAnnotation
    @PostMapping("/update")
    @ResponseBody
    public boolean updateUser(@RequestBody UserUpdateVO userUpdateVO) {
        log.info(String.format("/user/update userUpdateVO: %s", userUpdateVO.toString()));
        return userService.updateUser(userUpdateVO);
    }

    @TokenAnnotation
    @PostMapping("/resetPassword/{id}")
    @ResponseBody
    public boolean resetPassword(@PathVariable(name = "id") int id) {
        log.info(String.format("/user/resetPassword id: %d", id));
        return userService.resetPassword(id);
    }

    @TokenAnnotation
    @PostMapping("/remove/{id}")
    @ResponseBody
    public boolean removeUser(@PathVariable(name = "id") int id) {
        log.info(String.format("/user/remove id: %d", id));
        return userService.removeUser(id);
    }
}
