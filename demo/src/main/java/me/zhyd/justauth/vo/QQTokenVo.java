package me.zhyd.justauth.vo;

import lombok.Data;

@Data
public class QQTokenVo {

    private String accessToken;

    private String refreshToken;

    private Long expiresIn;
}
