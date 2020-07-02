package net.gichain.genergy.eam.admin.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.common.constant.CommonConstants;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.common.util.DateUtils;
import net.gichain.genergy.eam.common.util.StringUtils;

@Slf4j
public class JwtUtils {
    private static final String SECRET = "WgtqaT1HNTZPZNMDJu3k";

    public static String resolveAuthorization(String authorization) {
        if (StringUtils.isNullOrEmpty(authorization)) {
            return null;
        }

        String prefix = "Bearer ";
        int index = authorization.indexOf(prefix);
        return authorization.substring(index + prefix.length());
    }

    /**
     * 创建token
     *
     * @param id       编号
     * @param username 用户名
     * @param uuid     uuid
     * @return
     */
    public static String createToken(int id, String username, String uuid) {
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + CommonConstants.JWT_EXPIRATION);
        log.info(String.format("JwtUtils.createToken issuedDate: %s", DateUtils.dateToStr(issuedDate)));
        log.info(String.format("JwtUtils.createToken expireDate: %s", DateUtils.dateToStr(expireDate)));

        Map<String, Object> claims = new HashMap<>(1);
        claims.put("id", id);
        claims.put("username", username);
        claims.put("uuid", uuid);
        log.info(String.format("JwtUtils.createToken claims: %s", claims));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(issuedDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static Claims getClaim(String token) throws TokenException {
        if (token == null) {
            throw new TokenException(CodeEnum.AUTHORIZED_REQUIRED);
        }

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception exception) {
            throw new TokenException(CodeEnum.TOKEN_ANALYSIS_ERROR);
        }
        log.info(String.format("JwtUtils.getClaim claims: %s", claims));
        return claims;
    }

    public static boolean isExpired(String token) throws TokenException {
        final Date expiration = getExpiration(token);
        log.info(String.format("JwtUtils.isExpired expiration: %s", DateUtils.dateToStr(expiration)));
        log.info(String.format("JwtUtils.isExpired now: %s", DateUtils.dateToStr(new Date())));
        log.info(String.format("JwtUtils.isExpired before: %s", expiration.before(new Date())));
        return expiration.before(new Date());
    }

    public static Date getIssuedAt(String token) throws TokenException {
        return getClaim(token).getIssuedAt();
    }

    public static Date getExpiration(String token) throws TokenException {
        return getClaim(token).getExpiration();
    }

    public static int getUserId(String token) throws TokenException {
        Object id = getClaim(token).get("id");
        return Integer.parseInt(String.valueOf(id));
    }

    public static String getUUID(String token) throws TokenException {
        Object uuid = getClaim(token).get("uuid");
        return String.valueOf(uuid);
    }
}
