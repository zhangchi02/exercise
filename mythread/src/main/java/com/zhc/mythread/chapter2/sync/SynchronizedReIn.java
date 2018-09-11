package com.zhc.mythread.chapter2.sync;

public class SynchronizedReIn extends Thread {
	synchronized public void service1() {
		System.out.println("service1");
		service2();
	}

	synchronized public void service2() {
		System.out.println("service2");
		service3();
	}

	synchronized public void service3() {
		System.out.println("service3");
	}

	public void run() {
		SynchronizedReIn service = new SynchronizedReIn();
		service.service1();
	}

	public static void main(String[] args) {
		SynchronizedReIn thread = new SynchronizedReIn();
		thread.start();
	}

}
