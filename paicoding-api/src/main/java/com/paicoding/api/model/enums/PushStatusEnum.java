package com.paicoding.api.model.enums;

import lombok.Getter;

/**
 * 发布状态枚举
 */
@Getter
public enum PushStatusEnum {
    OFFLINE(0,"未发布"),
    ONLINE(1,"已发布"),
    REVIEW(2,"审核");

    PushStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;
}
