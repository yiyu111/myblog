package com.yiyu.controller;

import com.yiyu.common.ResultEntity;
import com.yiyu.entity.User;
import com.yiyu.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
@Validated
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public ResultEntity login(@RequestBody@Validated User user){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return ResultEntity.fail("请勿重复登录");
        }
        String name=user.getName();
        String password=user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (IncorrectCredentialsException e){
            log.error(e.getMessage(),e);
            return ResultEntity.fail("用户名或密码错误");
        } catch (AuthenticationException e) {
            log.error(e.getMessage(),e);
            return ResultEntity.fail("用户不存在");
        }
        return ResultEntity.success(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
    }

    @GetMapping("/logout")
    public ResultEntity logout(){

        if (!SecurityUtils.getSubject().isAuthenticated()){
            return ResultEntity.fail("请先登录");
        }
        SecurityUtils.getSubject().logout();
        return ResultEntity.success("登出成功");

    }
}
