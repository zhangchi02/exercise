package com.zhc.commonjava.getproper;

public class TestProper{
	public static void main(String[] args){
		System.out.println(System.getProperty("FROM_PROPERTY"));
		
		System.out.println("��ӡ���еĲ���:");  
        if(args.length>0){  
            for(int i=0;i<args.length;i++){  
                System.out.println("��"+i+"������Ϊ:"+args[i]);  
            }  
        }  
        System.out.println("��ӡϵͳ����:");  
        String env = System.getProperty("service.env");  
        System.out.println("service.env:"+env);  
        String logpath = System.getProperty("logfile.path");  
        System.out.println("logfile.path:"+logpath);  
	}
}