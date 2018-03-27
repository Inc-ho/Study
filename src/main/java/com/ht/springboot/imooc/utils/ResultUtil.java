package com.ht.springboot.imooc.utils;

import com.ht.springboot.imooc.dto.Result;

/**
 * @USER Min
 * @DATE 2018/3/9 ${Time}
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
