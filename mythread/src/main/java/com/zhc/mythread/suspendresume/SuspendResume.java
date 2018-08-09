package com.zhc.mythread.suspendresume;

public class SuspendResume extends Thread {
	private long i = 0;

	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}

	public void run() {
		while (true) {
			i++;
		}
	}

	public static void main(String[] args) {
		try {
			SuspendResume thread = new SuspendResume();
			thread.start();
			Thread.sleep(5000);

			thread.suspend();
			System.out.println("A= " + System.currentTimeMillis() + " i = " + thread.getI());
			Thread.sleep(5000);
			System.out.println("A= " + System.currentTimeMillis() + " i = " + thread.getI());

			thread.resume();
			Thread.sleep(5000);

			thread.suspend();
			System.out.println("B= " + System.currentTimeMillis() + " i = " + thread.getI());
			Thread.sleep(5000);
			System.out.println("B= " + System.currentTimeMillis() + " i = " + thread.getI());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
