package com.zhc.girl.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zhc.girl.domain.Result;
import com.zhc.girl.exception.GirlException;
import com.zhc.girl.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public Result handle(Exception e){
		if(e instanceof GirlException){
			GirlException girlException = (GirlException) e;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		}else{
			logger.error("【系统异常】{}",e);
			return ResultUtil.error(-1,"未知错误");
		}
	}
}
