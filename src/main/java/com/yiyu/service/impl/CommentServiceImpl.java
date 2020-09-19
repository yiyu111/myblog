package com.yiyu.service.impl;

import com.yiyu.entity.Comment;
import com.yiyu.mapper.CommentMapper;
import com.yiyu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> selectByUserId(int userId) {
        return commentMapper.selectByUserId(userId);
    }

    @Override
    public List<Comment> selectByBlogId(int blogId) {
        return commentMapper.selectByBlogId(blogId);
    }
}
