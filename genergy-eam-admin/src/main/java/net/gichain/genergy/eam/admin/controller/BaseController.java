package net.gichain.genergy.eam.admin.controller;

import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.common.util.JwtUtils;
import net.gichain.genergy.eam.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    private HttpServletRequest httpRequest;

    public String getToken() {
        String authorization = this.httpRequest.getHeader("Authorization");
        if (StringUtils.isNullOrEmpty(authorization)) {
            return null;
        }

        String token = JwtUtils.resolveAuthorization(authorization);
        if (StringUtils.isNullOrEmpty(token)) {
            return null;
        }

        return token;
    }

    public Integer getUserId() throws TokenException {
        String token = this.getToken();
        return JwtUtils.getUserId(token);
    }

    public boolean isExpired() throws TokenException {
        String token = this.getToken();
        return JwtUtils.isExpired(token);
    }
}
