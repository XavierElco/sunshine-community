package com.xav.sunshinecommunity.web.controller.common;

import com.wf.captcha.SpecCaptcha;
import com.xav.sunshinecommunity.common.constant.Constants;
import com.xav.sunshinecommunity.common.utils.ChainedMap;
import com.xav.sunshinecommunity.common.utils.UUIDUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

/**
 * 获取验证码
 * @author Li,chengming
 * @date 2026/1/29 16:51
 */
@RestController
public class CaptchaController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("captchaImage")
    public ChainedMap getCode(HttpServletResponse response) {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        // 生成验证码以及验证码的唯一标识
        String uuid = UUIDUtils.simpleUUID();

        // 拼接redis的key
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String code = specCaptcha.text().toLowerCase();

        // 验证码保存到redis
        redisTemplate.opsForValue().set(key, code, Duration.ofMinutes(10));

        return ChainedMap.create().set("uuid", uuid).set("img", specCaptcha.toBase64());

    }

}
