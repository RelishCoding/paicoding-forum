package com.paicoding.api.model.enums;

import lombok.Getter;

/**
 * 状态的枚举
 */
@Getter
public enum YesOrNoEnum {
    NO(0,"N","否","no"),
    YES(1,"Y","是","yes");

    YesOrNoEnum(int code, String desc, String cnDesc, String enDesc) {
        this.code = code;
        this.desc = desc;
        this.cnDesc = cnDesc;
        this.enDesc = enDesc;
    }

    private final int code;
    private final String desc;
    private final String cnDesc;
    private final String enDesc;
}
