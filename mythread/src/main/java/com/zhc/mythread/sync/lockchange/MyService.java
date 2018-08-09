package com.zhc.mythread.sync.lockchange;

public class MyService {
	private String lock = "123";

	public void testMethod() {
		try {
			synchronized (lock) {
				System.out.println(
						Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis() + " lock = "+lock);
				lock = "456";
				Thread.sleep(2000);
				System.out.println(
						Thread.currentThread().getName() + "   end time = " + System.currentTimeMillis() + " lock = "+lock);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
