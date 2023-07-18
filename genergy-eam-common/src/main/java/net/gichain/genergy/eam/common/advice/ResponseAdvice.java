package net.gichain.genergy.eam.common.advice;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.JsonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, ResponseBody.class})
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info(String.format("ResponseAdvice.beforeBodyWrite body: %s", body));
        Object result = JsonResult.success(body);
        if (body instanceof String) {
            result = JSON.toJSONString(result);
        }
        log.info(String.format("ResponseAdvice.beforeBodyWrite result: %s", result));
        return result;
    }
}
