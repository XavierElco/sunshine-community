package com.xav.sunshinecommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xav.sunshinecommunity.system.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表数据层
 * @author Li,chengming
 * @date 2026/1/30 18:22
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户id查询角色权限
     * @param userId
     * @return
     */
    public List<String> selectRolePermissionByUserId(Long userId);
}
