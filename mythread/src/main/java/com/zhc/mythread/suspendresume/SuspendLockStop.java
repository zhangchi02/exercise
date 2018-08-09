package com.zhc.mythread.suspendresume;

public class SuspendLockStop extends Thread {
	private long i = 0;

	public void run() {
		while (true) {
			i++;
			//System.out.println(i);
		}
	}

	public static void main(String[] args) {
		try {
			SuspendLockStop thread = new SuspendLockStop();
			thread.start();
			Thread.sleep(500);
			thread.suspend();
			System.out.println("main end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
