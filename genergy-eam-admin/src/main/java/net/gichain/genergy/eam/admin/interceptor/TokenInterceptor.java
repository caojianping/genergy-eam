package net.gichain.genergy.eam.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.service.IRedisService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.admin.util.JwtUtils;
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

    @Autowired
    private IRedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 判断是否包含token注解
        boolean hasTokenAnnotation = method.isAnnotationPresent(TokenAnnotation.class);
        log.info(String.format("TokenInterceptor hasTokenAnnotation: %s", hasTokenAnnotation));
        if (hasTokenAnnotation) {
            // 判断token注解的必要性
            TokenAnnotation tokenAnnotation = method.getAnnotation(TokenAnnotation.class);
            boolean isRequired = tokenAnnotation.required();
            log.info(String.format("TokenInterceptor isRequired: %s", isRequired));
            if (isRequired) {
                String authorization = httpServletRequest.getHeader("Authorization");
                log.info(String.format("TokenInterceptor authorization: %s", authorization));

                String token = JwtUtils.resolveAuthorization(authorization);
                log.info(String.format("TokenInterceptor token: %s", token));
                if (token == null) {
                    throw new TokenException(CodeEnum.AUTHORIZED_REQUIRED);
                }

                int userId = JwtUtils.getUserId(token);
                String uuid = JwtUtils.getUUID(token);
                log.info(String.format("TokenInterceptor userId,uuid: %d %s", userId, uuid));

                boolean isExist = this.userService.isExistById(userId);
                log.info(String.format("TokenInterceptor isExist: %s", isExist));
                if (!isExist) {
                    redisService.removeTokenCache(userId, uuid);
                    throw new TokenException(CodeEnum.INVALID_USERINFO);
                }

                boolean isJwtExpired = JwtUtils.isExpired(token);
                boolean isTokenExpired = redisService.isTokenExpired(userId, uuid);
                log.info(String.format("TokenInterceptor isJwtExpired,isTokenExpired: %s %s", isJwtExpired, isTokenExpired));
                if (isJwtExpired || isTokenExpired) {
                    if (isJwtExpired) {
                        redisService.removeTokenCache(userId, uuid);
                    }
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
