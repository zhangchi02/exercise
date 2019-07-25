package com.zhc.commonjava.strtest;

public class IndexOfTest {

	public static final String PREFIX = "classpath*:";

	public static void main(String[] args) {
		System.out.println(sub(1));
		System.out.println("123456".substring(1,2));
		System.out.println("123456".indexOf("3"));
		System.out.println("123456".length());
	}
	
	public static void getPath(){
		String locationPattern = "classpath*:config/log4j.properties";
		String newPattern = locationPattern.substring(PREFIX.length());
		boolean flag = IndexOfTest.isPattern(newPattern);
		System.out.println("newPattern: " + newPattern);
		System.out.println("flag: " + flag);
	}

	public static boolean isPattern(String path) {
		return (path.indexOf('*') != -1 || path.indexOf('?') != -1);
	}
	
	public static String sub(int index) {
		String prestr = "0123456";
		String newstr = prestr.substring(index);
		return newstr;
	}

}
