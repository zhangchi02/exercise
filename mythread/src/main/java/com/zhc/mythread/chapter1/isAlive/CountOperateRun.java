package com.zhc.mythread.chapter1.isAlive;

public class CountOperateRun {

	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		Thread t1 = new Thread(c);
		System.out.println("main begin t1 isAlive = "+t1.isAlive());
		t1.setName("A");
		t1.start();
		System.out.println("main end t1 isAlive = "+t1.isAlive());
		
		CountOperate c2 = new CountOperate();
	}

}
