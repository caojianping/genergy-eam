package net.gichain.genergy.eam.admin.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取缓存的过期时间
     *
     * @param key 键
     * @return long
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存的过期时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return boolean
     */
    public boolean setExpire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断缓存中是否包含指定的键
     *
     * @param key 键
     * @return boolean
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断缓存中是否包含指定的键（模糊匹配key）
     *
     * @param prefix 模糊前缀
     * @return boolean
     */
    public boolean hasKeyByPrefix(String prefix) {
        Set<String> keys = redisTemplate.keys(prefix);
        log.info(String.format("hasKeyByPrefix keys: %s", keys));
        return !CollectionUtils.isEmpty(keys);
    }

    /**
     * 删除缓存
     *
     * @param keys 单个或者多个键
     */
    @SuppressWarnings("unchecked")
    public void delete(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
    }

    /**
     * 删除缓存（模糊匹配key）
     *
     * @param prefix 模糊前缀
     */
    public void deleteByPrefix(String prefix) {
        Set<String> keys = redisTemplate.keys(prefix);
        log.info(String.format("deleteByPrefix keys: %s", keys));
        if (!CollectionUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    //============================String=============================

    /**
     * 获取String缓存
     *
     * @param key 键
     * @return Object
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置String缓存
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置String缓存 && 过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增String缓存
     *
     * @param key   键
     * @param delta 递增因子
     * @return long
     */
    public long increment(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减String缓存
     *
     * @param key   键
     * @param delta 递减因子
     * @return long
     */
    public long decrement(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    // ================================ Hash ================================= //

    /**
     * 获取Hash缓存的数据项
     *
     * @param key  键
     * @param item 项
     * @return Object
     */
    public Object getHashItem(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 设置Hash缓存的数据项
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return boolean
     */
    public boolean setHashItem(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置Hash缓存的数据项 && 过期时间
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public boolean setHashItem(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取Hash缓存的多个数据项
     *
     * @param key 键
     * @return Map<Object, Object>
     */
    public Map<Object, Object> getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 设置Hash缓存的多个数据项
     *
     * @param key 键
     * @param map 值
     * @return boolean
     */
    public boolean setHash(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置Hash缓存的多个数据项 && 过期时间
     *
     * @param key  键
     * @param map  值
     * @param time 时间(秒)
     * @return boolean
     */
    public boolean setHash(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除Hash缓存的数据项
     *
     * @param key  键
     * @param item 项
     */
    public void deleteHashItem(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断Hash缓存中是否包含指定的数据项
     *
     * @param key  键
     * @param item 项
     * @return boolean
     */
    public boolean hasHashKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * 递增Hash缓存
     *
     * @param key  键
     * @param item 项
     * @param by   递增因子
     * @return double
     */
    public double incrementHash(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * 递减Hash缓存
     *
     * @param key  键
     * @param item 项
     * @param by   递减因子
     * @return double
     */
    public double decrementHash(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    // ============================ Set ============================= //

    /**
     * 获取Set缓存
     *
     * @param key 键
     * @return Set<Object>
     */
    public Set<Object> getSet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 设置Set缓存
     *
     * @param key    键
     * @param values 值
     * @return long
     */
    public long setSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 设置Set缓存 && 过期时间
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值
     * @return long
     */
    public long setSet(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                setExpire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取Set缓存的长度
     *
     * @param key 键
     * @return long
     */
    public long getSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 判断Set缓存中是否包含指定的数据项
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public boolean hasSetKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除Set缓存
     *
     * @param key    键
     * @param values 值
     * @return long
     */
    public long removeSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // =============================== List ================================= //

    /**
     * 获取List缓存
     *
     * @param key   键
     * @param start 开始索引
     * @param end   结束索引
     * @return List<Object>
     */
    public List<Object> getList(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取List缓存的数据项
     *
     * @param key   键
     * @param index 索引
     * @return Object
     */
    public Object getListItem(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 设置List缓存的数据项
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public boolean setList(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置List缓存的数据项 && 过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public boolean setList(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置List缓存的多个数据项
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public boolean setList(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置List缓存的多个数据项 && 过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public boolean setList(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新List缓存的数据项
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return boolean
     */
    public boolean updateList(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取List缓存的长度
     *
     * @param key 键
     * @return long
     */
    public long getListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除List缓存
     *
     * @param key   键
     * @param count 移除个数
     * @param value 值
     * @return long
     */
    public long removeList(String key, long count, Object value) {
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
