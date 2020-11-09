package com.zcy;

public enum UserTypeEnum {

    /**
     * manager
     */
    MANAGER("管理员"),

    /**
     * nomal
     */
    NORMAL("普通用户"),

    /**
     * vip
     */
    VIP("会员");

    private String desc;

    UserTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static UserTypeEnum toEnum(String name) {
        for (UserTypeEnum typeEnum : UserTypeEnum.values()) {
            if (typeEnum.name().equalsIgnoreCase(name)) {
                return typeEnum;
            }
        }
        return null;
    }
}
