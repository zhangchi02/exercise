package com.zhc.mythread.chapter1.priority;

import java.util.Random;

public class PriorityVelocity extends Thread {
	private int i=0;
	public void run() {
		while(true){
			i++;
		}
			
	}

	public static void main(String[] args) {
		try {
			PriorityVelocity thread1 = new PriorityVelocity();
			thread1.setPriority(NORM_PRIORITY - 3 );
			thread1.start();
			PriorityVelocity thread2 = new PriorityVelocity();
			thread2.setPriority(NORM_PRIORITY + 3 );
			thread2.start();
			Thread.sleep(3000);
			thread1.stop();
			thread2.stop();
			System.out.println("thread1µÄi="+thread1.i);
			System.out.println("thread2µÄi="+thread2.i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
