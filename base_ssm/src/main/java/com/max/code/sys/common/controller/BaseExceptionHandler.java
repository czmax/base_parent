package com.max.code.sys.common.controller;


import com.max.code.sys.common.entity.Result;
import com.max.code.sys.common.entity.StatusCode;
import com.max.code.sys.common.exception.IException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(BaseExceptionHandler.class);

    //@ExceptionHandler(value = Exception.class)
    //public Result error(Exception e){
    //    e.printStackTrace();
    //    return new Result(false, StatusCode.ERROR, "执行出错");
    //}

    /**
     * 信息无法读取
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleHttpMessageNotReadableException(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, "无法读取");
    }

    /**
     * 处理参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMethodArgumentNotValidException(Exception e){
        return new Result(false, StatusCode.ERROR, "参数验证失败");
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(IException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public Result handleIException(IException e){
        return new Result(false, StatusCode.ERROR, "自定义异常");
    }

    /**
     * 数学计算错误
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleArithmeticException(ArithmeticException e){
        return new Result(false, StatusCode.ERROR, "服务器内部错误");
    }

    /**
     * 登陆错误
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleAuthenticationException(AuthenticationException e){
        LOGGER.error(e);
        return new Result(false, StatusCode.ERROR, "登陆错误");
    }
    /**
     * 没有权限——shiro
     * @param e
     * @return
     */
    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleUnknownAccountException(UnknownAccountException e){
        LOGGER.error(e);
        return new Result(false, StatusCode.ERROR, "请登录");
    }


    /**
     * 没有权限——shiro
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleUnauthorizedException(UnauthorizedException e){
        return new Result(false, StatusCode.ACCESSERROR, "没有权限");
    }

}
