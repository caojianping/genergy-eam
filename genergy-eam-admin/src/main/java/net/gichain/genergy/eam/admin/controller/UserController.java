package net.gichain.genergy.eam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.vo.UserVO;
import net.gichain.genergy.eam.admin.controller.dto.UserPasswordDTO;
import net.gichain.genergy.eam.common.annotations.TokenAnnotation;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import net.gichain.genergy.eam.database.entity.User;
import net.gichain.genergy.eam.admin.service.IUserService;
import net.gichain.genergy.enums.AccountTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @TokenAnnotation
    @GetMapping("/page/{pageNum}/{pageSize}")
    @ResponseBody
    public IPage<UserVO> page(
            @PathVariable(name = "pageNum") int pageNum,
            @PathVariable(name = "pageSize") int pageSize
    ) {
        Page<User> page = new Page<User>(pageNum, pageSize);
        return UserVO.converFromUserPage(userService.page(page));
    }

    @TokenAnnotation
    @PostMapping("/add")
    @ResponseBody
    public boolean add() throws BusinessException {
        return true;
    }

    @TokenAnnotation
    @PostMapping("/update")
    @ResponseBody
    public boolean update() throws BusinessException {
        return true;
    }

    @TokenAnnotation
    @PostMapping("/remove")
    @ResponseBody
    public boolean remove(@RequestBody UserPasswordDTO userPasswordDTO) throws BusinessException {
        return true;
    }

    @TokenAnnotation
    @PostMapping("/updatePassword")
    @ResponseBody
    public boolean updatePassword(@RequestBody UserPasswordDTO userPasswordDTO) throws BusinessException {
        log.info(String.format("/user/updatePassword args: %s", userPasswordDTO.toString()));
        return userService.updatePassword(userPasswordDTO.getId(), userPasswordDTO.getNewPwd(), userPasswordDTO.getConfirmPwd());
    }

    @TokenAnnotation
    @PostMapping("/resetPassword")
    @ResponseBody
    public boolean resetPassword(int userId) throws BusinessException {
        return true;
    }
}
