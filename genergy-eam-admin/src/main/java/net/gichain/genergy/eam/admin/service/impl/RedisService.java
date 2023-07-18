package net.gichain.genergy.eam.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.service.IRedisService;
import net.gichain.genergy.eam.admin.util.RedisUtils;
import net.gichain.genergy.eam.common.constant.CacheConstants;
import net.gichain.genergy.eam.common.constant.CommonConstants;
import net.gichain.genergy.eam.common.util.PasswordUtils;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService implements IRedisService {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean addTokenCache(int userId, String uuid) {
        String prefix = CacheConstants.CACHE_EAM_ADMIN_TOKEN + PasswordUtils.MD5Encrypt(String.valueOf(userId)) + "_";
        redisUtils.deleteByPrefix(prefix + "*");

        String key = prefix + uuid;
        return redisUtils.set(key, true, CommonConstants.JWT_EXPIRATION / 1000);
    }

    @Override
    public void removeTokenCache(int userId, String uuid) {
        String prefix = CacheConstants.CACHE_EAM_ADMIN_TOKEN + PasswordUtils.MD5Encrypt(String.valueOf(userId)) + "_";
        redisUtils.delete(prefix + uuid);
    }

    @Override
    public boolean isTokenExpired(int userId, String uuid) {
        String prefix = CacheConstants.CACHE_EAM_ADMIN_TOKEN + PasswordUtils.MD5Encrypt(String.valueOf(userId)) + "_";
        boolean result = redisUtils.hasKey(prefix + uuid);
        log.info(String.format("RedisService.isTokenExpired hasKey: %s %s", prefix, result));
        return !result;
    }
}
