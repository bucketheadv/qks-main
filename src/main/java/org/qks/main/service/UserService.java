package org.qks.main.service;

import io.quarkus.redis.client.RedisClientName;
import io.quarkus.redis.datasource.RedisDataSource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.qks.main.dao.UserDAO;
import org.qks.main.dao.po.UserPo;

@Slf4j
@Singleton
public class UserService {
    @Inject
    UserDAO userDAO;

    @RedisClientName("db2")
    RedisDataSource redisDataSource;

    public UserPo getUserById(Long id) {
        var valueCommands = redisDataSource.value(String.class);
        var c = valueCommands.get("abc");
        log.info("获取redis值: {}", c);
        return userDAO.findById(id);
    }
}
