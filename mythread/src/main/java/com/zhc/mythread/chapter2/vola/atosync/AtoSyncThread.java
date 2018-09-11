package com.zhc.mythread.chapter2.vola.atosync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtoSyncThread extends Thread {
	private AtomicInteger count = new AtomicInteger(0);

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread Name:" + Thread.currentThread().getName() + " " + count.incrementAndGet());
		}
	}

	public static void main(String[] args) {
		AtoSyncThread countService = new AtoSyncThread();
		Thread thread1 = new Thread(countService);
		thread1.start();
		Thread thread2 = new Thread(countService);
		thread2.start();
		Thread thread3 = new Thread(countService);
		thread3.start();
		Thread thread4 = new Thread(countService);
		thread4.start();
		Thread thread5 = new Thread(countService);
		thread5.start();
	}

}
