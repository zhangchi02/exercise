package com.zhc.servicecomb.consumer;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

public class ConsumerMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Log4jUtils.init();
		BeanUtils.init();
		
		new Consumer().run("api");
	}

}
