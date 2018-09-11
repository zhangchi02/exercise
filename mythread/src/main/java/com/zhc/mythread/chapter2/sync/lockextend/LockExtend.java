package com.zhc.mythread.chapter2.sync.lockextend;

public class LockExtend extends Thread{

	public void run(){
		ChildI child = new ChildI();
		child.operateIChildMethod();
	}
	public static void main(String[] args) {
		LockExtend thread = new LockExtend();
		thread.start();
	}

}
