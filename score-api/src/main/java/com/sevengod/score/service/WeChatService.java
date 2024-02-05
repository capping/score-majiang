package com.sevengod.score.service;

import com.sevengod.score.pojo.Code2SessionNotice;
import com.sevengod.score.util.WeChatMappingJackson2HttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Seven God
 * @since 2022-01-31 21:42
 */
@Service
public class WeChatService {
    @Value("${wx.app_id}")
    private String appId;

    @Value("${wx.app_secret}")
    private String appSecret;

    @Value("${wx.url.code2session}")
    private String code2session;

    @Value("${wx.grant_type}")
    private String grantType;

    public Code2SessionNotice getOpenId(String code) {
        String url = code2session + "?appid=" + appId
                + "&secret=" + appSecret + "&js_code=" + code
                + "&grant_type=" + grantType;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WeChatMappingJackson2HttpMessageConverter());
        Code2SessionNotice notice = restTemplate.getForObject(url, Code2SessionNotice.class);
        return notice;
    }
}
