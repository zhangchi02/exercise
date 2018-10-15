package com.zhc.enums;

import lombok.Getter;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
@Getter
public enum PayStatusEnum {

	WAIT(0,"等待支付"),
	SUCCESS(1,"支付成功"),
	;
	
	private Integer code;

	private String msg;

	PayStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
