package com.max.code.base.common.util;


import com.max.code.base.common.entity.Result;

/**
 *
 */
public class ResultUtil {
    public static Result success(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(10000);
        result.setMsg("success");
        result.setData(data);

        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
