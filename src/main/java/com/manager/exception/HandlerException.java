package com.manager.exception;

import com.manager.util.http.Result;
import com.manager.util.http.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Description : XXXX
 * Author by zengh17
 * Date on 2021/2/2 18:41
 */
@ControllerAdvice
public class HandlerException {

    private static final Logger logger = LoggerFactory.getLogger(HandlerException.class);

    /**
     * 处理未知异常
     * @param e
     * @return
     */

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result unknowException(Exception e){
        logger.error("发生了未知错误："+e.getMessage());
        e.printStackTrace();
        Result result =new Result();
        result.setCode(StatusCode.ERROR);
        result.setMessage("系统出现未知异常，请于管理员联系");
        /**
         * 未知异常的话，这里写逻辑，发邮件，发短信都可以、、
         */
        return result;
    }

    /**
     * 处理已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = CheckException.class)
    @ResponseBody
    public Result handlerCheckException(CheckException e){
        logger.error("发生了已知错误："+e.getMessage());
        Result result =new Result();
        result.setCode(StatusCode.ERROR);
        result.setMessage(e.getMessage());
        return result;
    }
}
