package com.xav.sunshinecommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xav.sunshinecommunity.system.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理数据层
 * @author Li,chengming
 * @date 2026/1/14 17:05
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 查询部门管理数据
     * @param sysDept
     * @return
     */
    List<SysDept> selectDeptList(SysDept sysDept);


}
