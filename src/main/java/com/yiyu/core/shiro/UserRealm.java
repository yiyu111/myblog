package com.yiyu.core.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.User;
import com.yiyu.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User principal = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        if (principal.getName().equals(RoleConstant.ADMIN)){
            simpleAuthenticationInfo.addRole(RoleConstant.ADMIN);
        }else {
            simpleAuthenticationInfo.addRole(RoleConstant.GUEST);
        }
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=token.getPrincipal().toString();
        User trueUser = userService.getOne(new QueryWrapper<User>().eq("name", userName));
        if (null==trueUser){
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(trueUser, trueUser.getPassword(), ByteSource.Util.bytes(trueUser.getSalt()),getName());

        return simpleAuthenticationInfo;
    }
}
