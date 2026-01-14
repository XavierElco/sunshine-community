package com.xav.sunshinecommunity.system.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 区域数据传输对象
 * @author Li,chengming
 * @date 2026/1/12 21:15
 */
public class SysAreaDto implements Serializable {
    private static final long serialVersionUID = 8328665491762414286L;

    /**
     * 城市编码
     */
    private Integer code;
    /**
     * 城市名称
     */
    private String name;

    /**
     * 子区域
     */
    private List<SysAreaDto> children;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysAreaDto> getChildren() {
        return children;
    }

    public void setChildren(List<SysAreaDto> children) {
        this.children = children;
    }

}
