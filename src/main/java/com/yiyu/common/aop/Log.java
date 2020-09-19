package com.yiyu.common.aop;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
    BusinessTybe businessType();
    TargetType targetType();
}
