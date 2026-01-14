package com.xav.sunshinecommunity.common.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class BaseEntity implements Serializable {


    private static final long serialVersionUID = -7334121469445554281L;

    /**
     * 搜索值
     */
    @TableField(exist = false) // 这个字段不属于数据库字段, mybatis在新增的时候会忽略该字段
    private String searchValue;

    /**
     * 请求参数, 接受前端发来的数据
     */
    @TableField(exist = false)
    private Map<String, Object> params;

    // 创建者
    @TableField(fill= FieldFill.INSERT) // 告诉mybatis,只有在插入操作的时候才需要
    private String createBy;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill= FieldFill.INSERT) // 告诉mybatis,只有在插入操作的时候才需要
    private Date createTime;

    // 更新者
    @TableField(fill= FieldFill.INSERT_UPDATE) // 告诉mybatis,只有在插入修改操作的时候才需要
    private String updateBy;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill= FieldFill.INSERT_UPDATE) // 告诉mybatis,只有在插入修改操作的时候才需要
    private Date updateTime;

    // 备注
    private String remark;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }



    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }



    public String getRemark() {
        return remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BaseEntity() {
    }

    public BaseEntity(String searchValue, Map<String, Object> params, String createBy, Date createTime, String updateBy, Date updateTime, String remark) {
        this.searchValue = searchValue;
        this.params = params;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }
}
