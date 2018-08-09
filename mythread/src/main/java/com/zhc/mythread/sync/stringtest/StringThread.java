package com.zhc.mythread.sync.stringtest;

public class StringThread extends Thread{

	private StringService service;
	
	public StringThread(StringService service) {
		super();
		this.service = service;
	}

	public void run(){
		service.print("AA");
	}
	public static void main(String[] args) {
		StringService myService = new StringService();
		StringThread thread1 = new StringThread(myService);
		thread1.setName("a");
		thread1.start();
		StringThread thread2 = new StringThread(myService);
		thread2.setName("b");
		thread2.start();
		
	}

}
