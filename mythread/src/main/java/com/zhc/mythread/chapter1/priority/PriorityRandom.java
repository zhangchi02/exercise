package com.zhc.mythread.chapter1.priority;

import java.util.Random;

public class PriorityRandom extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextInt();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " use time " + (endTime - beginTime) + "ºÁÃë£¡");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			PriorityRandom thread1 = new PriorityRandom();
			thread1.setName("thread1");
			thread1.setPriority(5);
			thread1.start();
			PriorityRandom thread2 = new PriorityRandom();
			thread2.setName("thread2");
			thread2.setPriority(6);
			thread2.start();

		}
	}

}
