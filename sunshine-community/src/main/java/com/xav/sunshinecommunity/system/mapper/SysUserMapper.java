package com.xav.sunshinecommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xav.sunshinecommunity.system.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li,chengming
 * @date 2026/1/29 17:19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    SysUser selectUserByUserName(String username);

}
