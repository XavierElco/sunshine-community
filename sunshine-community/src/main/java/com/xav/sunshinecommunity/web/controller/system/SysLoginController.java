package com.xav.sunshinecommunity.web.controller.system;

import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.common.utils.ChainedMap;
import com.xav.sunshinecommunity.common.utils.ServletUtils;
import com.xav.sunshinecommunity.framework.service.SysPermissionService;
import com.xav.sunshinecommunity.system.domain.LoginUser;
import com.xav.sunshinecommunity.system.domain.SysUser;
import com.xav.sunshinecommunity.system.domain.vo.LoginBody;
import com.xav.sunshinecommunity.system.service.SysLoginService;
import com.xav.sunshinecommunity.system.service.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 登陆验证
 * @author Li,chengming
 * @date 2026/1/29 18:41
 */
@RestController
public class SysLoginController {

    @Resource
    private SysLoginService sysLoginService;

    @Resource
    private SysPermissionService sysPermissionService;

    @Resource
    private TokenService tokenService;


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


    /**
     * 获取用户信息和权限信息
     * @return
     */
    @GetMapping("/getInfo")
    public ChainedMap getInfo() {

        // 用户信息
        LoginUser  loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getSysUser();

        // 获取角色集合
        Set<String> roles = sysPermissionService.getRolePermission(user);

        // 权限集合
        Set<String> perms = sysPermissionService.getMenuPermission(user);

        ChainedMap map = ChainedMap.create().set("code", 200).set("msg", "操作成功");

        map.put("user", user);
        map.put("roles", roles);
        map.put("permissions", perms);

        return map;
    }
}
