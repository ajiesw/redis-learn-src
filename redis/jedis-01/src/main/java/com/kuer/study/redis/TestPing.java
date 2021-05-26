package com.kuer.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author kuer
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.92.130", 6379);
        System.out.println(jedis.ping());

        Transaction multi = jedis.multi();
        Pipeline pipelined = jedis.pipelined();
        multi.set("name", "kuer");
        multi.set("age", "18");
        multi.exec();

        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        pipelined.sync();
        multi.close();
    }
}
