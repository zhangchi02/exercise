package com.zhc.mythread.chapter2.sync.statictest.twolock;

public class TwoLockService extends Thread {
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
				"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
		System.out.println(
				"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
	}

	synchronized public void printC() {
		System.out.println(
				"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
		System.out.println(
				"ThreadName: " + Thread.currentThread().getName() + " beginTime: " + System.currentTimeMillis());
	}
}
