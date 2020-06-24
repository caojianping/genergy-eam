package net.gichain.genergy.eam.admin.controller;

import net.gichain.genergy.eam.common.JsonResult;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.exception.ParameterException;
import net.gichain.genergy.eam.common.exception.TokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return JsonResult.failure(businessException.getCode(), businessException.getMessage());
        }

        if (exception instanceof ParameterException) {
            ParameterException parameterException = (ParameterException) exception;
            return JsonResult.failure(parameterException.getCode(), parameterException.getMessage());
        }

        if (exception instanceof TokenException) {
            TokenException tokenException = (TokenException) exception;
            return JsonResult.failure(tokenException.getCode(), tokenException.getMessage());
        }

        CodeEnum codeEnum = CodeEnum.UNKNOW_ERROR;
        return JsonResult.failure(codeEnum.getCode(), codeEnum.getMessage());
    }
}