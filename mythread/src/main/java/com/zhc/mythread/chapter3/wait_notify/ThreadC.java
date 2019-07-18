package com.zhc.mythread.chapter3.wait_notify;

public class ThreadC extends Thread {
	private C c;

	public ThreadC(C c) {
		super();
		this.c = c;
	}
	
	public void run() {
		while(true) {
			c.getValue();
		}
	}
}
