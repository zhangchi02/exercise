package com.zhc.mythread.chapter2.sync.stringtest;

public class ObjectThread extends Thread{

	private ObjectService service;
	
	public ObjectThread(ObjectService service) {
		super();
		this.service = service;
	}

	public void run(){
		service.print(new Object());
	}
	public static void main(String[] args) {
		ObjectService myService = new ObjectService();
		ObjectThread thread1 = new ObjectThread(myService);
		thread1.setName("a");
		thread1.start();
		ObjectThread thread2 = new ObjectThread(myService);
		thread2.setName("b");
		thread2.start();
		
	}

}
