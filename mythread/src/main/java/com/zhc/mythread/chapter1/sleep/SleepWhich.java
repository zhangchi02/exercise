package com.zhc.mythread.chapter1.sleep;

public class SleepWhich extends Thread {

	public void run() {
		try {
			System.out.println("run begin: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			for (int i = 0; i < 5; i++) {
				Thread.sleep(100);
				System.out.println("i = " + i);
			}
			System.out.println("run end: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			System.out.println("main begin: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			SleepWhich thread = new SleepWhich();
			thread.start();
//			Thread.sleep(2000);
			thread.sleep(2000);
			System.out.println("main end: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
