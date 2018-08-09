package com.zhc.mythread.yield;

public class YieldTest extends Thread{

	public void run(){
		long beginTime = System.currentTimeMillis();
		int count=0;
		for(int i = 0;i<5000000;i++){
			Thread.yield();
			count = count + (i + 1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ÓÃÊ±£º"+(endTime-beginTime)+"ºÁÃë£¡");
	}
	public static void main(String[] args) {
		YieldTest thread = new YieldTest();
		thread.start();
	}

}
