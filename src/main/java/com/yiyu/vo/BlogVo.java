package com.yiyu.vo;

import com.yiyu.entity.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogVo {

    private Integer id;
    private String title;
    private String content;
    private String description;
    private LocalDateTime creatTime;
    private List<Tag> tags;
}
