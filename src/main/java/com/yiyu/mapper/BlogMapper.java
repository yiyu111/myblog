package com.yiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yiyu.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */

@Component
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> selectByUserId(@Param("userId")int userId);


}
