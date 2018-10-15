/**  
 * Project Name:sell  
 * File Name:ProductStatus.java  
 * Package Name:com.zhc.enums  
 * Date:2018年1月6日下午6:16:35  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.enums;

import lombok.Getter;

/**  
 * ClassName:ProductStatus <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年1月6日 下午6:16:35 <br/>  
 * @author   l00228291  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Getter
public enum ProductStatus {

	UP(0,"在架"),
	DOWN(1,"下架")
	;
	
	private Integer code;

	private String msg;
	
	ProductStatus(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
  
