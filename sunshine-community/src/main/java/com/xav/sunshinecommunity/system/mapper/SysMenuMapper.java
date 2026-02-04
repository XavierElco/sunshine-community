package com.xav.sunshinecommunity.system.mapper;

import com.xav.sunshinecommunity.system.domain.SysMenu;
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


    /**
     * 用户为admin， 查询全部菜单信息
     * @return
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * 根据用户id 查询菜单信息
     * @param
     * @return: 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);
}
