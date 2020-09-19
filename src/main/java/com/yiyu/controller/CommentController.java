package com.yiyu.controller;


import com.yiyu.common.ResultEntity;
import com.yiyu.common.aop.BusinessTybe;
import com.yiyu.common.aop.Log;
import com.yiyu.common.aop.TargetType;
import com.yiyu.common.constant.RoleConstant;
import com.yiyu.entity.Comment;
import com.yiyu.service.impl.CommentServiceImpl;
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
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;


    @GetMapping("/blog/{blogId}")
    public ResultEntity getBlogComment(@PathVariable("blogId")int blogId){
        List<Comment> comments = commentService.selectByBlogId(blogId);
        return ResultEntity.success(comments);
    }

    @GetMapping("/user/{userId}")
    public ResultEntity getUserComment(@PathVariable("userId")int userId){
        List<Comment> commentList = commentService.selectByUserId(userId);
        return ResultEntity.success(commentList);
    }

    @PostMapping("/creat")
    public ResultEntity commentCreat(@RequestBody@Validated Comment comment){
        commentService.save(comment);
        return ResultEntity.success("创建成功");
    }

    @Log(businessType = BusinessTybe.DELETE,targetType = TargetType.Comment)
    @RequiresRoles(RoleConstant.ADMIN)
    @DeleteMapping("/delete")
    public ResultEntity deleteComment(int id){
        commentService.removeById(id);
        return ResultEntity.success("删除成功");
    }
}
