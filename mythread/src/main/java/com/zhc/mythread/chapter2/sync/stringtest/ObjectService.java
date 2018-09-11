package com.zhc.mythread.chapter2.sync.stringtest;

public class ObjectService {

	public static void print(Object object) {
		try {
			synchronized (object) {
				while (true) {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
