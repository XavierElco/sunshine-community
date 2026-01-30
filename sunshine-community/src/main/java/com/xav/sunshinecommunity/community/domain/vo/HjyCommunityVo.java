package com.xav.sunshinecommunity.community.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xav.sunshinecommunity.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * 数据传输
 * @author Li,chengming
 * @date 2026/1/9 22:25
 */
public class HjyCommunityVo implements Serializable {

    private static final long serialVersionUID = 630235435803237326L;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    /** 小区编号 *///
    private Long communityId;

    /** 小区名称*///
    private String communityName;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public HjyCommunityVo(Long communityId, String communityName) {
        this.communityId = communityId;
        this.communityName = communityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public HjyCommunityVo() {
    }
}

