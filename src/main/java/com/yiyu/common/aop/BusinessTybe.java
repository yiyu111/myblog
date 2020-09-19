package com.yiyu.common.aop;

import lombok.Getter;

@Getter
public enum  BusinessTybe {
    CREAT("creat"),
    DELETE("delete"),
    UPDATE("update");

    private  String value;

    BusinessTybe(String value) {
        this.value = value;
    }
}
