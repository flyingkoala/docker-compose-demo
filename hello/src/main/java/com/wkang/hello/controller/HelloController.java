package com.wkang.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wkang
 * @description:
 * @since 2022/2/17 17:32
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/world")
    public String world(){
        logger.info("myapp works!");
        Long counter = redisTemplate.opsForValue().increment("counter");
        return "myapp is running " + counter + "times!";
    }
}
