package com.yiyu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiyu.entity.Blog;
import com.yiyu.mapper.BlogMapper;
import com.yiyu.mapper.BlogTagMapper;
import com.yiyu.mapper.TagMapper;
import com.yiyu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogTagMapper blogTagMapper;
    @Autowired
    TagMapper tagMapper;

    @Override
    public IPage<Blog> page(IPage<Blog> page) {
        IPage<Blog> blogipage = super.page(page);

        return blogipage;
    }

    @Override
    public List<Blog> selectByUserId(int userId) {
        return blogMapper.selectByUserId(userId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(Blog entity) {
        return  super.save(entity);
    }
}
