package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.common.constant.UserConstants;
import com.xav.sunshinecommunity.system.domain.SysMenu;
import com.xav.sunshinecommunity.system.domain.vo.MetaVo;
import com.xav.sunshinecommunity.system.domain.vo.RouterVo;
import com.xav.sunshinecommunity.system.mapper.SysMenuMapper;
import com.xav.sunshinecommunity.system.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static javax.swing.text.StyleConstants.getComponent;

/**
 * @author Li,chengming
 * @date 2026/1/30 20:28
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuMapper sysMenuMapper;



    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        List<String> list = sysMenuMapper.selectMenuPermissionByUserId(userId);

        HashSet<String> set = new HashSet<>();

        for (String perms : list) {
            if (Objects.nonNull(perms) && !Objects.equals(perms, "")) {
                set.add(perms);
            }

        }
        return set;
    }

    @Override
    public List<SysMenu> selectMenuTreeByUserId(Long userId) {
        List<SysMenu> menus = null;
        if(userId != null && 1L == userId){
            menus = sysMenuMapper.selectMenuTreeAll();
        }else{
            menus = sysMenuMapper.selectMenuTreeByUserId(userId);
        }

        //todo 获取子菜单
        return getChildPerms(menus,0L);
    }

    /**
     * 根据父节点ID 获取子节点
     * @param menus 菜单列表
     * @param parentId 父菜单ID
     * @return 有父子结构的菜单
     */
    private List<SysMenu> getChildPerms(List<SysMenu> menus,Long parentId){

        List<SysMenu> returnList = new ArrayList<>();
        menus.stream()
                .filter(m->m.getParentId().equals(parentId))
                        .forEach(m -> {
                            recursionFn(menus,m);
                            returnList.add(m);
                        });

            return returnList;
    }

    /**
     * 递归获取子菜单
     * @param menus
     * @param m
     */
    private void recursionFn(List<SysMenu> menus, SysMenu m) {
        // 1. 获取子节点的列表
        List<SysMenu> childMenu = getChildList(menus, m);
        m.setChildren(childMenu);
        for(SysMenu t : childMenu){
            // 判断子节点下面有没有子节点
            if (getChildList(menus, t).size() > 0 ? true : false) {
                recursionFn(menus, t);
            }
        }
    }


    /**
     * 得到子节点列表
     * @param menus
     * @param m
     * @return
     */
    private List<SysMenu>  getChildList(List<SysMenu> menus, SysMenu m) {
        return menus.stream().filter(
                subMenu -> subMenu.getParentId().longValue()
                        == m.getMenuId().longValue())
                        .collect(Collectors.toList());
    }

    @Override
    public List<RouterVo> buildMenus(List<SysMenu> menus) {

        ArrayList<RouterVo> list = new ArrayList<>();

        for (SysMenu menu : menus) {
            RouterVo routerVo = new RouterVo();
            routerVo.setName(getRouterName(menu));
            routerVo.setPath(getRouterPath(menu));
            routerVo.setComponent(getComponentInfo(menu));
            routerVo.setHidden("1".equals(menu.getVisible()));
            routerVo.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), "1".equals(menu.getIsCache())));
            List<SysMenu> subMenuList = menu.getChildren();
            if(!subMenuList.isEmpty() && subMenuList.size() > 0 &&
                UserConstants.TYPE_DIR.equals(menu.getMenuType())) {
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
                // 递归设置子菜单
                routerVo.setChildren(buildMenus(subMenuList));
            }

            list.add(routerVo);

        }
        return list;
    }


    /**
     * 获取组件信息
     * @param menu
     * @return
     */
    private String getComponentInfo(SysMenu menu) {
        String layout = UserConstants.LAYOUT;

        // 如果是子菜单
        if (!StringUtils.isEmpty(layout)) {
            layout = menu.getComponent();
        }
        // 如果不是父菜单，但菜单类型是目录
        else if (menu.getParentId().intValue() != 0 && UserConstants.LAYOUT.equals(menu.getMenuType())) {
            layout = UserConstants.PARENT_VIEW;
        }

        return layout;
    }


    /**
     * 获取路由的地址
     * @param menu
     * @return
     */
    private String getRouterPath(SysMenu menu) {

        String routerPath = menu.getPath();

        if (menu.getParentId().intValue() == 0 && UserConstants.TYPE_DIR.equals(menu.getMenuType())) {
            routerPath = "/" + menu.getPath();
        }
        return routerPath;
    }

    /**
     * 获取路由名称
     * @param menu
     * @return
     */
    private String getRouterName(SysMenu menu) {

        String routerPath = menu.getPath();
        String routerName = StringUtils.capitalize(routerPath);
        return routerName;

    }
}
