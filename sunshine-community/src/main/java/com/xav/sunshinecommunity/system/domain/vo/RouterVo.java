package com.xav.sunshinecommunity.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/30 23:48
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterVo {
    private String name;
    private String path;
    private boolean hidden;
    private String redirect;
    private String component;
    private Boolean alwaysShow;
    private MetaVo meta;
    private List<RouterVo> children;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getAlwaysShow() {
        return this.alwaysShow;
    }

    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public MetaVo getMeta() {
        return this.meta;
    }

    public void setMeta(MetaVo meta) {
        this.meta = meta;
    }

    public List<RouterVo> getChildren() {
        return this.children;
    }

    public void setChildren(List<RouterVo> children) {
        this.children = children;
    }
}
