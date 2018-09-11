package com.zhc.mythread.chapter2.sync.block.dirtyread;

public class MyService {

	public MyOneList addServiceMethod(MyOneList list, String data) {
		try {
			synchronized (list) {
				if (list.getSize() < 1) {
					Thread.sleep(2000);
					System.out.println("currentThread: " + Thread.currentThread().getName());
					list.add(data);
				}
			}
			System.out.println("currentThread: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list;
	}
}
