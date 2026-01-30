package com.xav.sunshinecommunity.system.mapper;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 菜单表
 * @author Li,chengming
 * @date 2026/1/30 18:32
 */
@Controller
public interface SysMenuMapper {


    /**
     * 根据用户Id 查询菜单权限
     * @param userId
     * @return
     */
    public List<String> selectMenuPermissionByUserId(Long userId);
}
