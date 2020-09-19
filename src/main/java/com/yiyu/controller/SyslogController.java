package com.yiyu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyu.common.ResultEntity;
import com.yiyu.entity.Syslog;
import com.yiyu.service.impl.SyslogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yiyu
 * @since 2020-08-24
 */
@RestController
@RequestMapping("/syslog")
public class SyslogController {
    @Autowired
    SyslogServiceImpl syslogService;

    @GetMapping("/list")
    public ResultEntity list(@RequestParam int pages, @RequestParam("size")int size){
        Page<Syslog> page = new Page<>(pages, size);
        IPage<Syslog> iPage = syslogService.page(page);
        return  ResultEntity.success(iPage);
    }
}
