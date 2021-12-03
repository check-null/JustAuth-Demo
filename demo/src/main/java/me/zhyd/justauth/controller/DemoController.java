package me.zhyd.justauth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.zhyd.justauth.component.Oauth2Component;
import me.zhyd.justauth.vo.QQInfoVo;
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

    @Resource
    Oauth2Component oauth2Component;

    @GetMapping("qq/callback")
    public Map<String, Object> qq(String code, String state) {
        System.out.println("localhost8080.site/aouth/qq/callback");

        String token = oauth2Component.getToken(code, state);
        String openId = oauth2Component.getOpenId(token);

        QQInfoVo userInfo = oauth2Component.getUserInfo(token, openId);
        String jsonString = JSON.toJSONString(userInfo);
        redisTemplate.opsForValue().set("user_info", jsonString);

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("user_info", userInfo);
        return map;
    }

    @GetMapping("test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>(16);
        final Object userInfo = redisTemplate.opsForValue().get("user_info");
        map.put("user_info", userInfo);
        return map;
    }
}
