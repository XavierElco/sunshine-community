package com.xav.sunshinecommunity.web.controller.system;

import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.common.utils.ChainedMap;
import com.xav.sunshinecommunity.system.domain.vo.LoginBody;
import com.xav.sunshinecommunity.system.service.SysLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登陆验证
 * @author Li,chengming
 * @date 2026/1/29 18:41
 */
@RestController
public class SysLoginController {

    @Resource
    private SysLoginService sysLoginService;


    /**
     * 登陆方法
     * @param loginBody
     * @return
     */
    @PostMapping("/login")
    public ChainedMap login(@RequestBody LoginBody loginBody){
        // 生成令
        String token = sysLoginService.login(loginBody.getUsername(), loginBody.getPassword(),
                loginBody.getCode(), loginBody.getUuid());

        if (token.isEmpty()) {
            throw new BaseException("令牌生成错误");
        }
        return ChainedMap.create().set("token", token);
    }
}
