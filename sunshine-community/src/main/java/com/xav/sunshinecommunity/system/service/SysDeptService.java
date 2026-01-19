package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.SysDept;

import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/14 17:12
 */
public interface SysDeptService {

    /**
     * 查询部门管理数据
     * @param sysDept
     * @return
     */
    List<SysDept> selectDeptList(SysDept sysDept);


}
