package com.yiyu.service.impl;

import com.yiyu.entity.Tag;
import com.yiyu.mapper.TagMapper;
import com.yiyu.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-28
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
