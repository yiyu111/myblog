package com.yiyu.mapper;

import com.yiyu.entity.BlogTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 博客和标签关联表 Mapper 接口
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-28
 */
@Component
public interface BlogTagMapper extends BaseMapper<BlogTag> {

}
