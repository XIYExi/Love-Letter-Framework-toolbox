package com.xion.wiki.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(RestCode.SUCCESS_CODE);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(RestCode.ERROR_CODE);
        r.setMessage("失败");
        return r;
    }


    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R error(Boolean error){
        this.setSuccess(error);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> data){
        this.setData(data);
        return this;
    }
}
