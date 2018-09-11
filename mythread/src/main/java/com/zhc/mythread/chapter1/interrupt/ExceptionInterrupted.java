package com.zhc.mythread.chapter1.interrupt;

public class ExceptionInterrupted extends Thread {
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.isInterrupted()) {
					System.out.println("已经是停止状态了！我要退出执行了！");
					// break;
					throw new InterruptedException();
				}
				System.out.println("i= " + (i + 1));
			}
			System.out.println("我在for后面，还会执行！！！");
		} catch (InterruptedException e) {
			System.out.println("进入run()方法中的catch了" + this.isInterrupted());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ExceptionInterrupted fi = new ExceptionInterrupted();
			fi.start();
			Thread.sleep(2000);
			fi.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
