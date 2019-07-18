package com.zhc.mythread.chapter3.wait_notify;

public class ThreadP extends Thread {
	private P p;

	public ThreadP(P p) {
		super();
		this.p = p;
	}
	
	public void run() {
		while(true) {
			p.setValue();
		}
	}
}
