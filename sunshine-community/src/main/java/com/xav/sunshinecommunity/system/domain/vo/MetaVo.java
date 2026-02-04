package com.xav.sunshinecommunity.system.domain.vo;

/**
 * @author Li,chengming
 * @date 2026/1/30 23:49
 */
public class MetaVo {
    private String title;
    private String icon;
    private boolean noCache;

    public MetaVo() {
    }

    public MetaVo(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public MetaVo(String title, String icon, boolean noCache) {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
    }

    public boolean isNoCache() {
        return this.noCache;
    }

    public void setNoCache(boolean noCache) {
        this.noCache = noCache;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

