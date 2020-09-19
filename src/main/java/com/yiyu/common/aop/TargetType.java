package com.yiyu.common.aop;

import lombok.Getter;

@Getter
public enum TargetType {
    User("user"),
    Comment("comment"),
    Blog("blog"),
    Tag("tag");

    TargetType(String value) {
        this.value = value;
    }

    private String value;
}
