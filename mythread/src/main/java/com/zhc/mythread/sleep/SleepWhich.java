package com.zhc.mythread.sleep;

public class SleepWhich extends Thread {

	public void run() {
		try {
			System.out.println("run begin: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			Thread.sleep(4000);
			System.out.println("run begin: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			SleepWhich thread = new SleepWhich();
			SleepWhich thread2 = new SleepWhich();
			System.out.println("begin: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			thread.start();
			thread2.start();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+"�˳�sleep״̬������");
			thread2.sleep(30000);
			System.out.println(thread2.getName()+"�˳�sleep״̬������");
			System.out.println(thread.getName()+"����ִ��stop������");
			thread.stop();
			System.out.println("end: " + Thread.currentThread().getName() + " "  + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
