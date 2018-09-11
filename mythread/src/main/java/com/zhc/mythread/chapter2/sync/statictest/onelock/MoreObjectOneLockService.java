package com.zhc.mythread.chapter2.sync.statictest.onelock;

public class MoreObjectOneLockService extends Thread {
	synchronized public static void printA() {
		try {
			System.out.println(
					"线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "进入printA");
			Thread.sleep(3000);
			System.out.println(
					"线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "离开printA");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public static void printB() {
		System.out
				.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "进入printB");
		System.out
				.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "离开printB");
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
