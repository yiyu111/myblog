package com.yiyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.common.ResultEntity;
import com.yiyu.common.aop.BusinessTybe;
import com.yiyu.common.aop.Log;
import com.yiyu.common.aop.TargetType;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.Blog;
import com.yiyu.entity.BlogTag;
import com.yiyu.service.impl.BlogServiceImpl;
import com.yiyu.service.impl.BlogTagServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/like")
    public ResultEntity likePage(@RequestParam String like,@RequestParam int pages, @RequestParam("size")int size){
        Page<Blog> page=new Page<>(pages,size);
        IPage<Blog> iPage = blogService.page(page, new QueryWrapper<Blog>().like("title", like));
        return ResultEntity.success(iPage);
    }

    @GetMapping("/count")
    public ResultEntity countByTag(@RequestParam int tagId){
        Integer count = blogTagService.count(new QueryWrapper<BlogTag>().eq("tag_id", tagId));
        return ResultEntity.success(count);
    }

    @Log(businessType = BusinessTybe.CREAT,targetType = TargetType.Blog)
    @PostMapping("/create")
    public ResultEntity create(@RequestBody@Validated Blog blog){
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
