package com.zhc.log;

import org.apache.log4j.Logger;

public class MyLog {

	private static Logger logger = Logger.getLogger(MyLog.class);

	public static void main(String[] args) {
		// 记录debug级别的信息
		logger.debug("This is debug message.");
		// 记录info级别的信息
		logger.info("This is info message.");
		// 记录error级别的信息
		logger.error("This is error message.");

		logger.info("logger name :" + MyLog.class.getName());
	}

}
