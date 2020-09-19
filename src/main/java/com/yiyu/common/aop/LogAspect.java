package com.yiyu.common.aop;

import com.yiyu.entity.Syslog;
import com.yiyu.entity.User;
import com.yiyu.service.impl.SyslogServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Autowired
    SyslogServiceImpl syslogService;

    @Pointcut("@annotation(com.yiyu.common.aop.Log) ")
    public void log(){}

    @After("log()")
    public void joincut(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Log annotation = signature.getMethod().getAnnotation(Log.class);
        Syslog syslog = new Syslog();
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        assert principal!=null;
        syslog.setOperator(principal.getName());
        syslog.setType(annotation.businessType().getValue());
        syslog.setTarget(annotation.targetType().getValue());
        syslogService.save(syslog);
    }
}
