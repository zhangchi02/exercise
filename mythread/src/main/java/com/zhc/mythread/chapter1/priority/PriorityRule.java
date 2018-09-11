package com.zhc.mythread.chapter1.priority;

import java.util.Random;

public class PriorityRule extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " use time " + (endTime - beginTime) + "ºÁÃë£¡");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			PriorityRule thread1 = new PriorityRule();
			thread1.setName("thread1");
			thread1.setPriority(1);
			thread1.start();
			PriorityRule thread2 = new PriorityRule();
			thread2.setName("thread2");
			thread2.setPriority(10);
			thread2.start();

		}
	}

}
