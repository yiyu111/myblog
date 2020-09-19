package com.yiyu.service.impl;

import com.yiyu.entity.BlogTag;
import com.yiyu.mapper.BlogTagMapper;
import com.yiyu.service.BlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客和标签关联表 服务实现类
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-28
 */
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {

}
