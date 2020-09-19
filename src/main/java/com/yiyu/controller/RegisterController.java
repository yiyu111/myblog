package com.yiyu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yiyu.common.ResultEntity;
import com.yiyu.entity.User;
import com.yiyu.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RegisterController {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/register")
    public ResultEntity register(@RequestBody@Validated User aUser){
        String name=aUser.getName();
        String password=aUser.getPassword();
        User one = userService.getOne(new QueryWrapper<User>().eq("name", name));
        if (null!=one){
            return ResultEntity.fail("该用户名已经存在");
        }
        User user=new User();
        user.setName(name);
//        随机盐
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        user.setSalt(salt);
//        哈希算法MD5
        String encodePassword=new SimpleHash("md5",password,salt,1).toString();
        user.setPassword(encodePassword);
        userService.save(user);
        return  ResultEntity.success("注册成功");
    }


}
