package com.yiyu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.entity.Blog;
import com.yiyu.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogServiceImplTest {

    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    BlogMapper blogMapper;
    @Test
    void page() {
        IPage<Blog> page = blogService.page(new Page<>(1, 5));
        System.out.println(page.getRecords());
    }
}
