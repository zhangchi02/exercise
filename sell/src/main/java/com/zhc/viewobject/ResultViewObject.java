/**  
 * Project Name:sell  
 * File Name:ResultViewObject.java  
 * Package Name:com.zhc.viewobject  
 * Date:2018年1月6日下午6:58:25  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.viewobject;

import lombok.Data;

/**  
 * @author   zhangchi02  
 * @date        
 */
@Data
public class ResultViewObject<T> {

	/** 错误码. */
	private Integer code;
	
	/** 提示信息. */
	private String msg;
	
	/** 具体内容. */
	private T data;
}
  
