package com.yiyu.core.mapper;

import com.yiyu.entity.User;
import com.yiyu.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void test(){
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        System.out.println(salt);
        System.out.println(new Md5Hash(salt).toString());
        List<User> list = userService.list();
        System.out.println(list);
    }


}

