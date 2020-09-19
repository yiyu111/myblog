package com.yiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yiyu.entity.Blog;
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
public interface BlogService extends IService<Blog> {



    public List<Blog> selectByUserId(@Param("userId")int userId);
}
