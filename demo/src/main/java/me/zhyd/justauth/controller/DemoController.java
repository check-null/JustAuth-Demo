package me.zhyd.justauth.controller;

import me.zhyd.justauth.vo.QQVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("aouth")
public class DemoController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("qq/callback")
    public Map<String, String> qq(String code, String state) {
        System.out.println("localhost8080.site/aouth/qq/callback");
        redisTemplate.opsForValue().set("code", code);
        redisTemplate.opsForValue().set("state", state);
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("state", state);
        return map;
    }

    @GetMapping("test")
    public String test() {

        return "test";
    }
}
