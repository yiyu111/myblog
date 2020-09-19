package com.yiyu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.common.ResultEntity;
import com.yiyu.common.aop.BusinessTybe;
import com.yiyu.common.aop.Log;
import com.yiyu.common.aop.TargetType;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.User;
import com.yiyu.service.impl.UserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */
@RequiresRoles(RoleConstant.ADMIN)
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/list")
    public ResultEntity list(@RequestParam int pages, @RequestParam("size")int size){
        Page<User> page = new Page<>(pages, size);
        IPage<User> iPage = userService.page(page);
        return  ResultEntity.success(iPage);
    }

    @Log(businessType = BusinessTybe.DELETE,targetType = TargetType.User)
    @RequiresRoles(RoleConstant.ADMIN)
    @DeleteMapping("/delete")
    public ResultEntity delete(int id){
        userService.removeById(id);
        return ResultEntity.success("删除成功");
    }

}
