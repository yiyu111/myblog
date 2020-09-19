package com.yiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yiyu.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */


public interface CommentService extends IService<Comment> {


    public List<Comment> selectByUserId(@Param("userId")int userId);

    public List<Comment> selectByBlogId(@Param("blogId")int blogId);
}
