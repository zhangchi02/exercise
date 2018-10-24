package com.zhc.exception;

import com.zhc.enums.ResultEnum;

/**
 * @author zhangchi02
 * @date 2018年10月15日
 */
public class SellException extends RuntimeException {

	private Integer code;

	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());

		this.code = resultEnum.getCode();
	}
	
	public SellException(Integer code,String message){
		super(message);
		this.code = code;
	}

}
