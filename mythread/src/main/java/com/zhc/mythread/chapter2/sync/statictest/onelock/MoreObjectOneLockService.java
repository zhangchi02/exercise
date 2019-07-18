package com.zhc.mythread.chapter2.sync.statictest.onelock;

public class MoreObjectOneLockService extends Thread {
	synchronized public static void printA() {
		try {
			System.out.println(
					"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
			Thread.sleep(3000);
			System.out.println(
					"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public static void printB() {
		System.out.println(
				"ThreadName：" + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
		System.out.println(
				"ThreadName：" + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
	}

	public void run() {
		if (Thread.currentThread().getName().equals("a")) {
			printA();
		} else {
			printB();
		}
	}

	public static void main(String[] args) {
		MoreObjectOneLockService thread1 = new MoreObjectOneLockService();
		thread1.setName("a");
		thread1.start();
		MoreObjectOneLockService thread2 = new MoreObjectOneLockService();
		thread2.setName("b");
		thread2.start();

	}

}
