package com.zhc.mythread.interrupt;

public class InterruptSleep extends Thread {
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 100000; i++) {
				System.out.println("i = " + (i + 1));
			}
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			System.out.println("先停止，再遇到了sleep！进入catch！" + this.isInterrupted());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InterruptSleep is = new InterruptSleep();
		is.start();
		is.interrupt();
		System.out.println("end!!!");

	}

}
