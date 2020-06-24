package net.gichain.genergy.eam.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.common.util.JwtUtils;
import net.gichain.genergy.eam.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String authorization = httpServletRequest.getHeader("Authorization");
        log.info(String.format("TokenInterceptor authorization: %s", authorization));

        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 检查是否包含token注解
        log.info(String.format("TokenInterceptor isAnnotationPresent(): %s", method.isAnnotationPresent(TokenAnnotation.class)));
        if (method.isAnnotationPresent(TokenAnnotation.class)) {
            TokenAnnotation tokenAnnotation = method.getAnnotation(TokenAnnotation.class);
            log.info(String.format("TokenInterceptor required(): %s", tokenAnnotation.required()));
            if (tokenAnnotation.required()) {
                String token = JwtUtils.resolveAuthorization(authorization);
                log.info(String.format("TokenInterceptor token: %s", token));
                if (token == null) {
                    throw new TokenException(CodeEnum.AUTHORIZED_REQUIRED);
                }

                int userId = JwtUtils.getUserId(token);
                log.info(String.format("TokenInterceptor userId: %d", userId));

                boolean isExist = this.userService.isExistById(userId);
                log.info(String.format("TokenInterceptor isExist: %s", isExist));
                if (!isExist) {
                    throw new TokenException(CodeEnum.INVALID_USERINFO);
                }

                boolean isExpired = JwtUtils.isExpired(token);
                log.info(String.format("TokenInterceptor isExpired: %s", isExpired));
                if (isExpired) {
                    throw new TokenException(CodeEnum.TOKEN_EXPIRED);
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
