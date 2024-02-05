package com.sevengod.score.pojo;

import com.github.pagehelper.PageInfo;

public class ResponseResult {
    public Integer code = 0;

    public String msg = "成功";

    public PageInfo<?> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageInfo<?> getData() {
        return data;
    }

    public void setData(PageInfo<?> data) {
        this.data = data;
    }
}
