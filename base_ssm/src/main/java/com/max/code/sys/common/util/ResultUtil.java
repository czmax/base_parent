package com.max.code.sys.common.util;


import com.max.code.sys.common.entity.Result;

/**
 *
 */
public class ResultUtil {
    public static Result success(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);

        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(10000);
        result.setMessage("success");
        result.setData(data);

        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);

        return result;
    }
}
