package com.yiyu.common;

import lombok.Data;

@Data
public class ResultEntity {

    private final int code;
    private String msg;
    private Object data;

    public ResultEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultEntity fail(Object data){
        return new ResultEntity(400,"操作失败",data);
    }

    public static ResultEntity unauth(Object data){
        return new ResultEntity(401,"操作未授权",data);
    }

    public static ResultEntity success(Object data){
        return new ResultEntity(200,"操作成功",data);
    }

}
