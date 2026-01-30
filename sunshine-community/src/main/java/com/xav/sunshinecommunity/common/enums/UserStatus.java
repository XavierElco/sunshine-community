package com.xav.sunshinecommunity.common.enums;

/**
 * 用户状态枚举类型
 * @author Li,chengming
 * @date 2026/1/29 17:41
 */
public enum UserStatus {

    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
