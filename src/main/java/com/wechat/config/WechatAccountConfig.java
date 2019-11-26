package com.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信支付账号配置信息
 * Created by lxy on 2019/11/6.
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 公众平台id
     */
    private String mpAppId;
    /**
     * 公众平台密钥
     */
    private String mpAppSecret;
    /**
     * 支付商户号
     */
    private String mchId;
    /**
     * 支付密钥
     */
    private String mchKey;
    /**
     * 支付商户证书
     */
    private String keyPath;
    /**
     * 微信支付异步通知地址
     */
    private String NotifyUrl;
}
