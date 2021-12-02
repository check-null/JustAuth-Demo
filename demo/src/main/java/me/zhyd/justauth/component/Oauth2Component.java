package me.zhyd.justauth.component;

import com.alibaba.fastjson.JSONObject;
import lombok.Setter;
import me.zhyd.justauth.vo.QQInfoVo;
import me.zhyd.justauth.vo.QQOpenIdVo;
import me.zhyd.justauth.vo.QQTokenVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Setter
@Component
public class Oauth2Component {

    @Value("${qq.appid}")
    private String appId;

    @Value("${qq.appkey}")
    private String appKey;

    @Value("${qq.callback}")
    private String callback;

    public String getCode() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type={response_type}&client_id={client_id}&state={state}&redirect_uri={redirect_uri}";
        HashMap<String, String> map = new HashMap<>(16);
        map.put("response_type", "code");
        map.put("client_id", appId);
        map.put("state", String.valueOf(System.currentTimeMillis()));
        map.put("redirect_uri", callback);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, map);
        System.out.println("getCode ---> forEntity = " + forEntity);
        return forEntity.getBody();
    }

    public String getToken(String code, String state) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://graph.qq.com/oauth2.0/token?grant_type={grant_type}&client_id={client_id}&client_secret={client_secret}&code={code}&redirect_uri={redirect_uri}&fmt={fmt}";
        HashMap<String, String> map = new HashMap<>(16);
        map.put("grant_type", "authorization_code");
        map.put("client_id", appId);
        map.put("client_secret", appKey);
        map.put("code", code);
        map.put("redirect_uri", callback);
        map.put("fmt", "json");

        String forObject = restTemplate.getForObject(url, String.class, map);
        QQTokenVo parse = JSONObject.parseObject(forObject, QQTokenVo.class);
        System.out.println("getToken ---> forEntity = " + parse);
        assert parse != null;
        return parse.getAccessToken();
    }

    public String getOpenId(String token) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://graph.qq.com/oauth2.0/me?access_token={access_token}";
        HashMap<String, String> map = new HashMap<>(16);
        map.put("access_token", token);
        String forObject = restTemplate.getForObject(url, String.class, map);

        assert forObject != null;
        int indexOf = forObject.indexOf('{');
        int lastIndexOf = forObject.lastIndexOf('}') + 1;
        String substring = forObject.substring(indexOf, lastIndexOf);
        System.out.println("getOpenId ---> substring = " + substring);
        QQOpenIdVo qqOpenIdVo = JSONObject.parseObject(substring, QQOpenIdVo.class);

        return qqOpenIdVo.getOpenId();
    }

    public QQInfoVo getUserInfo(String token, String openId) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://graph.qq.com/user/get_user_info?access_token={access_token}&oauth_consumer_key={oauth_consumer_key}&openid={openid}";
        HashMap<String, String> map = new HashMap<>(16);
        map.put("access_token", token);
        map.put("oauth_consumer_key", appId);
        map.put("openid", openId);

        String forObject = restTemplate.getForObject(url, String.class, map);
        return JSONObject.parseObject(forObject, QQInfoVo.class);
    }

}
