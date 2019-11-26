package com.wechat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 微信授权示例练手
 * Created by lxy on 2019/11/6.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx234b65348218b500&secret=6d34d263f10fa89ec927320b146aee06&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
    }
}
