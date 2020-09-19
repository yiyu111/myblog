package com.yiyu.mapper;

import com.yiyu.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 标签 Mapper 接口
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-28
 */
@Component
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> selectByBlogId(@Param("id") int id);
}
