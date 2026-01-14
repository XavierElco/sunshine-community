package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.system.domain.SysArea;
import com.xav.sunshinecommunity.system.domain.dto.SysAreaDto;
import com.xav.sunshinecommunity.system.mapper.SysAreaMapper;
import com.xav.sunshinecommunity.system.service.SysAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取区域的完整树
 * @author Li,chengming
 * @date 2026/1/12 21:37
 */
@Service
public class SysAreaServiceImpl implements SysAreaService {

    @Resource
    private SysAreaMapper sysAreaMapper;

    @Override
    public List<SysAreaDto> findAreaAsTree() {
        // 获取区域表数据
        List<SysArea> list = sysAreaMapper.findAll();

        return list.stream()
                .filter(area -> area.getParentCode().equals(0))
                .map(area -> {
                    SysAreaDto dto = new SysAreaDto();
                    dto.setCode(area.getCode());
                    dto.setName(area.getName());
                    dto.setChildren(getChildrenArea(dto, list));
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * 递归设置区域信息
     * @param sysAreaDto
     * @param list
     * @return
     */
    private List<SysAreaDto> getChildrenArea(SysAreaDto sysAreaDto, List<SysArea> list) {
        // 通过获取当前父节点的id来查询子节点
        List<SysArea> subAreaList = list.stream().filter(area -> area.getParentCode().equals(sysAreaDto.getCode()))
                .collect(Collectors.toList()); // 把当前流转化为一个List集合

        if(!subAreaList.isEmpty()) {
            return subAreaList.stream().map(area -> {
                SysAreaDto dto = new SysAreaDto();
                dto.setCode(area.getCode());
                dto.setName(area.getName());
                // 递归
                dto.setChildren(getChildrenArea(dto, list));
                return dto;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
