package com.zhc.mythread.chapter3.wait_notify;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP pThread = new ThreadP(p);
		ThreadC cThread = new ThreadC(c);
		pThread.start();
		Thread.sleep(5000);
		cThread.start();
	}

}
