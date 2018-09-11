package com.zhc.girl.exception;

import com.zhc.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {

	private Integer code;

	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
