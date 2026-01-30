package com.xav.sunshinecommunity.community.service.impl;

import com.xav.sunshinecommunity.common.utils.OrikaUtils;
import com.xav.sunshinecommunity.community.domain.HjyCommunity;
import com.xav.sunshinecommunity.community.domain.dto.HjyCommunityDto;
import com.xav.sunshinecommunity.community.domain.vo.HjyCommunityVo;
import com.xav.sunshinecommunity.community.mapper.HjyCommunityMapper;
import com.xav.sunshinecommunity.community.service.HjyCommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Li,chengming
 * @date 2026/1/9 23:18
 */
@Service
public class HjyCommunityServiceImpl implements HjyCommunityService {

    @Resource
    private HjyCommunityMapper hjyCommunityMapper;

    private static final String CODE_PREFIX="COMMUNITY_";

    @Override
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.queryList(hjyCommunity);
    }

    @Override
    public Integer insertHjyCommunity(HjyCommunity hjyCommunity) {
        // 设置小区编码
        hjyCommunity.setCommunityCode(CODE_PREFIX+ System.currentTimeMillis());
        return hjyCommunityMapper.insert(hjyCommunity);
    }

    @Override
    public HjyCommunity selectHjyCommunityById(Long communityId) {
        return hjyCommunityMapper.selectById(communityId);
    }

    @Override
    public Integer deleteHjyCommunity(Long[] communityIds) {
        return hjyCommunityMapper.deleteBatchIds(Arrays.asList(communityIds));
    }

    @Override
    public Integer updateHjyCommunity(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.updateById(hjyCommunity);
    }

    @Override
    public List<HjyCommunityVo> queryPullDown(HjyCommunity hjyCommunity) {
        List<HjyCommunityDto> dtoList = hjyCommunityMapper.queryList(hjyCommunity);

        // 对象拷贝
        List<HjyCommunityVo> communityVoList = dtoList.stream().map(dto -> {

            // 使用Orika完成对象拷贝
            return OrikaUtils.convert(dto, HjyCommunityVo.class);
        }).collect(Collectors.toList());

        return communityVoList;
    }
}
