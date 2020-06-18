package net.gichain.genergy.eam.common.advice;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.JsonResult;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import net.gichain.genergy.eam.common.exceptions.ParameterException;
import net.gichain.genergy.eam.common.exceptions.TokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, ResponseBody.class})
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler
    public JsonResult handleException(Exception exception, HttpServletRequest request) {
        log.info(String.format("handleException exception: %s", exception));
        return JsonResult.failure(CodeEnum.SYSTEM_ERROR.getCode(), exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public JsonResult handleException(BusinessException exception, HttpServletRequest request) {
        return JsonResult.failure(exception.getCode(), exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public JsonResult handleException(ParameterException exception, HttpServletRequest request) {
        return JsonResult.failure(exception.getCode(), exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public JsonResult handleException(TokenException exception, HttpServletRequest request) {
        return JsonResult.failure(exception.getCode(), exception.getMessage());
    }
}
