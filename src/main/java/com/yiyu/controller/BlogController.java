package com.yiyu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.common.ResultEntity;
import com.yiyu.common.aop.BusinessTybe;
import com.yiyu.common.aop.Log;
import com.yiyu.common.aop.TargetType;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.Blog;
import com.yiyu.service.impl.BlogServiceImpl;
import com.yiyu.service.impl.BlogTagServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */
@RestController
@RequestMapping("api/blog")
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    BlogTagServiceImpl blogTagService;

    @GetMapping("/list")
    public ResultEntity listPage(@RequestParam int pages, @RequestParam("size")int size){
        Page<Blog> page=new Page<>(pages,size);
        IPage<Blog> iPage = blogService.page(page);
        return ResultEntity.success(iPage);
    }

    @GetMapping("/user/{userId}")
    public ResultEntity listUserBlogs(@PathVariable("userId")int userId){
        List<Blog> blogsByUserId = blogService.selectByUserId(userId);
        return ResultEntity.success(blogsByUserId);
    }

    @Log(businessType = BusinessTybe.CREAT,targetType = TargetType.Blog)
    @PostMapping("/creat")
    public ResultEntity creat(@RequestBody@Validated Blog blog){
        blogService.save(blog);
        return ResultEntity.success("创建成功");
    }

    @Log(businessType = BusinessTybe.DELETE,targetType = TargetType.Blog)
    @RequiresRoles(RoleConstant.ADMIN)
    @DeleteMapping("/delete")
    public ResultEntity delete(int id){
        blogService.deleteById(id);
        return ResultEntity.success("删除成功");
    }
}
