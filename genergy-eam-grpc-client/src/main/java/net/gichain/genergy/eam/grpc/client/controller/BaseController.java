package net.gichain.genergy.eam.grpc.client.controller;

import net.gichain.genergy.eam.common.JsonResult;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return JsonResult.failure(businessException.getCode(), businessException.getMessage());
        }

        CodeEnum codeEnum = CodeEnum.UNKNOW_ERROR;
        return JsonResult.failure(codeEnum.getCode(), codeEnum.getMessage());
    }
}