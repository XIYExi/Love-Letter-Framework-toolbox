package com.xion.wiki.config.handler;

import com.xion.wiki.config.exception.BusinessException;
import com.xion.wiki.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public R validExceptionHandler(BindException e) {
        LOG.warn("参数校验失败：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return R.error().message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R validExceptionHandler(BusinessException e) {
        LOG.warn("业务异常：{}", e.getCode().getDesc());
        return R.error().message(e.getCode().getDesc());
    }

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R validExceptionHandler(Exception e) {
        LOG.error("系统异常：", e);
        return R.error().message("系统出现异常，请联系管理员");
    }
}
