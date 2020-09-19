package com.yiyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private java.lang.Integer id;

    @Size(max = 50,message = "标题不能大于50个字符")
    private String title;

    @Size(min = 50,message = "内容不能少于50个字符")
    private String content;

    @Size(min = 50,message = "摘要不能少于50个字符")
    private String description;

    @NotNull
    private java.lang.Integer userId;

    private LocalDateTime creatTime;

    @TableField(exist = false)
    private List<Tag> tags;


}
