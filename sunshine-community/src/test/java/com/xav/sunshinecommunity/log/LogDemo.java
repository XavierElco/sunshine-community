package com.xav.sunshinecommunity.log;

/**
 * @author Li,chengming
 * @date 2026/1/19 22:18
 */

import com.xav.sunshinecommunity.system.domain.SysMenu;
import com.xav.sunshinecommunity.system.mapper.SysMenuMapper;
import com.xav.sunshinecommunity.system.service.SysRoleService;
import com.xav.sunshinecommunity.system.service.SysMenuService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Data
public class LogDemo {

    Logger logger = LoggerFactory.getLogger(LogDemo.class);

    @Test
    public void test1() {
        logger.info("Hello LogBack!!!");
    }

    @Test
    public void test2() {
        logger.trace("这个级别很少用");
        logger.debug("测试的时候多打印日志");
        logger.info("系统日志，没有什么问题，单纯的打印");
        logger.warn("错误很少见，而且不影响程序继续运行");
        logger.error("发生严重的错误,程序中断了，需要立即处理");
    }

    /**
     * 通过@slf4j注解方式打印
     */
    @Test
    public void test3() {
        log.trace("这个级别很少用");
        log.debug("测试的时候多打印日志");
        log.info("系统日志，没有什么问题，单纯的打印");
        log.warn("错误很少见，而且不影响程序继续运行");
        log.error("发生严重的错误,程序中断了，需要立即处理");
    }

    @Test
    public void test4() {
        String name = "我是大佬";
        log.info("hello" + name);
        log.debug("hello{}", name); // 推荐使用占位符
    }

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysMenuService sysMenuService;

    @Test
    public void testSelectRoleAndMenuByUserId() {
        Set<String> rolePerms = sysRoleService.selectRolePermissionByUserId(1L);
        System.out.println("用户角色权限信息" + rolePerms);

        Set<String> menuPerms = sysMenuService.selectMenuPermsByUserId(2L);
        System.out.println("菜单角色权限信息" + menuPerms);
    }

    @Resource
    SysMenuMapper sysMenuMapper;

    @Test
    public void testSelectMenuTreeAll() {
        List<SysMenu> sysMenus = sysMenuMapper.selectMenuTreeAll();
        System.out.println(sysMenus);
    }

    @Test
    public void testSelectMenuTreeByUserId() {
        List<SysMenu> sysMenus = sysMenuMapper.selectMenuTreeByUserId(2L);
        System.out.println(sysMenus);
    }

}
