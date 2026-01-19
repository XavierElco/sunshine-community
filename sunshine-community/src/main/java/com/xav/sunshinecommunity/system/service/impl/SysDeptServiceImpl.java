package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.system.domain.SysDept;
import com.xav.sunshinecommunity.system.mapper.SysDeptMapper;
import com.xav.sunshinecommunity.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/14 17:12
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    SysDeptMapper deptMapper;

    /**
     * 查询部门管理数据
     * @param sysDept
     * @return
     */
    @Override
    public List<SysDept> selectDeptList(SysDept sysDept) {
        return deptMapper.selectDeptList(sysDept);
    }
}
