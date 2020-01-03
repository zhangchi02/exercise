package com.zhc.commonjava.getproper;

public class TestProper{
	public static void main(String[] args){
		System.out.println(System.getProperty("FROM_PROPERTY"));
		
		System.out.println("打印所有的参数:");  
        if(args.length>0){  
            for(int i=0;i<args.length;i++){  
                System.out.println("第"+i+"个参数为:"+args[i]);  
            }  
        }  
        System.out.println("打印系统变量:");  
        String env = System.getProperty("service.env");  
        System.out.println("service.env:"+env);  
        String logpath = System.getProperty("logfile.path");  
        System.out.println("logfile.path:"+logpath);  
	}
}