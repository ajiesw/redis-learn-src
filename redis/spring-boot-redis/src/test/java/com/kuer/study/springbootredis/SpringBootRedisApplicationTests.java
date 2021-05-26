package com.kuer.study.springbootredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuer.study.springbootredis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplates")
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        // opsForValue操作字符串
        // opsForList操作list
        // ……

        // 获取连接
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("name", "kuer是我");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void Test01() throws JsonProcessingException {
        User user = new User();
        user.setName("kuer");
        user.setAge(18);
        // 序列化
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user1", jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user1"));
    }

}
