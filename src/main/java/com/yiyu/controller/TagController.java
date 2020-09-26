package com.yiyu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.common.ResultEntity;
import com.yiyu.common.aop.BusinessTybe;
import com.yiyu.common.aop.Log;
import com.yiyu.common.aop.TargetType;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.Tag;
import com.yiyu.service.impl.TagServiceImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-28
 */
@RestController
@RequestMapping("api/tag")
public class TagController {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping("/list")
    public ResultEntity list(@RequestParam int pages, @RequestParam("size")int size){
        Page<Tag> tagPage = new Page<>(pages,size);
        IPage<Tag> list = tagService.page(tagPage);
        return ResultEntity.success(list);
    }

    @Log(businessType = BusinessTybe.CREAT,targetType = TargetType.Tag)
    @RequiresRoles(RoleConstant.ADMIN)
    @PostMapping("/creat")
    public ResultEntity creat(@RequestBody@Validated Tag tag){
        tagService.save(tag);
        return ResultEntity.success("添加成功");
    }

    @Log(businessType = BusinessTybe.DELETE,targetType = TargetType.Tag)
    @RequiresRoles(RoleConstant.ADMIN)
    @DeleteMapping("/delete")
    public ResultEntity delete(int id){
        tagService.removeById(id);
        return  ResultEntity.success("删除成功");
    }

}
