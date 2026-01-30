package com.xav.sunshinecommunity.community.domain.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xav.sunshinecommunity.common.core.domain.BaseEntity;

/**
 * 数据传输
 * @author Li,chengming
 * @date 2026/1/9 22:25
 */
public class HjyCommunityDto extends BaseEntity {

    private static final long serialVersionUID = 5610991333566137154L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    /** 小区编号 *///
    private Long communityId;

    /** 小区名称*///
    private String communityName;

    /** 小区编码*/// 小区编码
    private String communityCode;

    /** 省区划码*/// 省区划码
    private String communityProvinceCode;

    /** 省名称*/// 省名称
    private String communityProvinceName;

    /** 市区划码 */
    private String communityCityCode;

    /** 市名称 */
    private String communityCityName;

    /** 区县划码*/// 区县划码
    private String communityTownCode;

    /** 区名称*/// 区名称
    private String communityTownName;

    /** 小区详细地址*/// 小区详细地址
    private String communityDetailedAddress;

    /** 小区经度*/// 小区经度
    private String longitude;

    /** 小区维度*/// 小区维度
    private String latitude;

    /** 物业ID*/// 物业ID
    private Long deptId;

    /** 排序*/// 排序
    private Integer communitySort;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityProvinceCode() {
        return communityProvinceCode;
    }

    public void setCommunityProvinceCode(String communityProvinceCode) {
        this.communityProvinceCode = communityProvinceCode;
    }

    public String getCommunityCityCode() {
        return communityCityCode;
    }

    public void setCommunityCityCode(String communityCityCode) {
        this.communityCityCode = communityCityCode;
    }

    public String getCommunityTownCode() {
        return communityTownCode;
    }

    public void setCommunityTownCode(String communityTownCode) {
        this.communityTownCode = communityTownCode;
    }

    public String getCommunityDetailedAddress() {
        return communityDetailedAddress;
    }

    public void setCommunityDetailedAddress(String communityDetailedAddress) {
        this.communityDetailedAddress = communityDetailedAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getCommunitySort() {
        return communitySort;
    }

    public void setCommunitySort(Integer communitySort) {
        this.communitySort = communitySort;
    }

    public String getCommunityProvinceName() {
        return communityProvinceName;
    }

    public void setCommunityProvinceName(String communityProvinceName) {
        this.communityProvinceName = communityProvinceName;
    }

    public String getCommunityCityName() {
        return communityCityName;
    }

    public void setCommunityCityName(String communityCityName) {
        this.communityCityName = communityCityName;
    }

    public String getCommunityTownName() {
        return communityTownName;
    }

    public void setCommunityTownName(String communityTownName) {
        this.communityTownName = communityTownName;
    }
}

