package com.zhc.mythread.chapter2.sync.block.dirtyread;

public class MyThread extends Thread {
	private MyOneList list;

	public MyThread(MyOneList list) {
		super();
		this.list = list;
	}

	public void run() {
		if (Thread.currentThread().getName().equals("A")) {
			MyService msRef = new MyService();
			msRef.addServiceMethod(list, "A");
		} else {
			MyService msRef = new MyService();
			msRef.addServiceMethod(list, "B");
		}
	}

	public static void main(String[] args) {
		MyOneList mylist = new MyOneList();
		MyThread thread1 = new MyThread(mylist);
		thread1.setName("A");
		thread1.start();
		MyThread thread2 = new MyThread(mylist);
		thread2.setName("B");
		thread2.start();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("listSize = " + mylist.getSize());
	}

}
