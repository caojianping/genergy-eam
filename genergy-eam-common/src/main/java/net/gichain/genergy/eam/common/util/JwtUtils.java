package net.gichain.genergy.eam.common.util;

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

@Slf4j
public class JwtUtils {
    private static final String USER_ID = "id";
    private static final String SECRET = "WgtqaT1HNTZPZNMDJu3k";
    private static final long EXPIRATION = CommonConstants.JWT_EXPIRATION;

    /**
     * 创建token（根据用户编号）
     *
     * @param userId 用户编号
     * @return
     */
    public static String createToken(int userId) {
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + EXPIRATION);
        log.info(String.format("JwtUtils.createToken issuedDate: %s", DateUtils.dateToStr(issuedDate)));
        log.info(String.format("JwtUtils.createToken expireDate: %s", DateUtils.dateToStr(expireDate)));
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(USER_ID, userId);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(issuedDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 创建token（根据负载数据）
     *
     * @param data 负载数据
     * @return
     */
    public static String createToken(Map<String, Object> data) {
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + EXPIRATION);
        log.info(String.format("JwtUtils.createToken issuedDate: %s", DateUtils.dateToStr(issuedDate)));
        log.info(String.format("JwtUtils.createToken expireDate: %s", DateUtils.dateToStr(expireDate)));
        return Jwts.builder()
                .setClaims(data)
                .setIssuedAt(issuedDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static Claims getClaim(String token) throws TokenException {
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

    public static Date getIssuedAt(String token) throws TokenException {
        return getClaim(token).getIssuedAt();
    }

    public static Date getExpiration(String token) throws TokenException {
        return getClaim(token).getExpiration();
    }

    public static String resolveAuthorization(String authorization) {
        if (StringUtils.isNullOrEmpty(authorization)) {
            return null;
        }

        String prefix = "Bearer ";
        int index = authorization.indexOf(prefix);
        return authorization.substring(index + prefix.length());
    }

    public static int getUserId(String token) throws TokenException {
        Object suid = getClaim(token).get(USER_ID);
        return Integer.parseInt(suid.toString());
    }

    public static boolean isExpired(String token) throws TokenException {
        final Date expiration = getExpiration(token);
        log.info(String.format("JwtUtils.isExpired expiration: %s", DateUtils.dateToStr(expiration)));
        log.info(String.format("JwtUtils.isExpired now: %s", DateUtils.dateToStr(new Date())));
        log.info(String.format("JwtUtils.isExpired before: %s", expiration.before(new Date())));
        return expiration.before(new Date());
    }
}
