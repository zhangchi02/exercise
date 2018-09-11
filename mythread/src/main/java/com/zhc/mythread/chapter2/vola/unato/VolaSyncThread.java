package com.zhc.mythread.chapter2.vola.unato;

public class VolaSyncThread extends Thread {

	volatile public static int count;

	/*private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}*/
	synchronized private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("thread name:"+Thread.currentThread().getName()+" count=" + count);
	}

	public void run() {
		addCount();
	}

	public static void main(String[] args) {
		VolaSyncThread[] threadArray = new VolaSyncThread[100];
		for (int i = 0; i < 100; i++) {
			threadArray[i] = new VolaSyncThread();
		}
		for (int i = 0; i < 100; i++) {
			threadArray[i].start();
		}
	}

}
