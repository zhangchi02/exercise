package com.zhc.mythread.chapter1.stop;

public class StopThread extends Thread {
	private int i=0;
	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i = " + (i + 1));
				System.out.println("run: " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			StopThread st = new StopThread();
			st.start();
			System.out.println("main: "+Thread.currentThread().getName());
			//Thread.sleep(18000);
			st.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
