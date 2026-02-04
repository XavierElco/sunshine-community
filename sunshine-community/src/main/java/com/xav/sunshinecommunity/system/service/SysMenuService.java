package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.SysMenu;
import com.xav.sunshinecommunity.system.domain.vo.RouterVo;

import java.util.List;
import java.util.Set;

/**
 * @author Li,chengming
 * @date 2026/1/30 20:27
 */
public interface SysMenuService {

    /**
     * 根据用户ID查询菜单信息
     * @param userId
     * @return
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据用户ID 查询菜单树信息
     * @param userId
     * @return: 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 构建前端路由所需要的格式
     * @param menus
     * @return
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);
}
