package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.dto.SysAreaDto;

import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/12 21:35
 */
public interface SysAreaService {
    List<SysAreaDto> findAreaAsTree();
}
