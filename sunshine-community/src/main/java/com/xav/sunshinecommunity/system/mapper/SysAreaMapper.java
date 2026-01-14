package com.xav.sunshinecommunity.system.mapper;

import com.xav.sunshinecommunity.system.domain.SysArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/12 21:23
 */
@Mapper
public interface SysAreaMapper {
    List<SysArea> findAll();
}
