package com.xav.sunshinecommunity.community.service;

import com.xav.sunshinecommunity.community.domain.HjyCommunity;
import com.xav.sunshinecommunity.community.domain.dto.HjyCommunityDto;

import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/9 23:17
 */
public interface HjyCommunityService {

    /**
     * 更具条件查询小区信息列表
     * @param hjyCommunity
     * @return
     */
    List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity);


    /**
     * 新增小区
     * @param hjyCommunity
     * @return
     */
    Integer insertHjyCommunity(HjyCommunity hjyCommunity);
}
