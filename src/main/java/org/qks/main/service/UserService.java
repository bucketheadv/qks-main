package org.qks.main.service;

import io.quarkus.redis.client.RedisClientName;
import io.quarkus.redis.datasource.RedisDataSource;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.qks.main.repository.hibernate.dao.UserDAO;
import org.qks.main.repository.mybatis.mapper.UserMapper;
import org.qks.main.repository.mybatis.po.UserEntity;

@Slf4j
@Singleton
public class UserService {
    @Inject
    UserDAO userDAO;
    @Inject
    UserMapper userMapper;

    @RedisClientName("db2")
    RedisDataSource redisDataSource;

    public UserEntity getUserById(Long id) {
        var valueCommands = redisDataSource.value(String.class);
        var c = valueCommands.get("abc");
        log.info("获取redis值: {}", c);
        return userMapper.findById(id);
    }
}
