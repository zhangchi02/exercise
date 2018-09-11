package com.zhc.mythread.chapter2.sync.atopro;

public class ThreadA extends Thread {
	private Service service;
	public ThreadA(Service service){
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.runMethod();
	}
}
