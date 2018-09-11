package com.zhc.commonjava.getproper;

import java.util.ArrayList;
import java.util.List;

public class TestEnv {
	public static void main(String[] args) {
		
		System.out.println(System.getenv("MYSQL_DB_IP"));
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(System.getenv("OS"));
		 

		/*String tempIp = "127.0.0.1";

		tempIp = null != System.getenv("MYSQL_DB_IP") ? System.getenv("MYSQL_DB_IP") : tempIp;

		if (null != System.getenv("MYSQL_DB_IP")) {
			tempIp = System.getenv("MYSQL_DB_IP");
			System.out.println("getenv: " + tempIp);
		} else if (null != System.getProperty("MYSQL_DB_IP")) {
			tempIp = System.getProperty("MYSQL_DB_IP");
			System.out.println("getProperty: " + tempIp);
		} else {
			System.out.println("tempIp: " + tempIp);
		}
		List datas = new ArrayList();
		datas.add("Mike");
		for (Object o : datas) {
			System.out.println((String) o);
		}*/
	}
}