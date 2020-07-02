package net.gichain.genergy.eam.admin.service;

public interface IRedisService {
    boolean addTokenCache(int userId, String uuid);

    void removeTokenCache(int userId, String uuid);

    boolean isTokenExpired(int userId, String uuid);
}
