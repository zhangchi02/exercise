package com.zhc.mythread.chapter2.vola.atosync;

public class AtoThread extends Thread {
	private AtoService atoService;

	public AtoThread(AtoService atoService) {
		this.atoService = atoService;
	}

	public void run() {
		atoService.addNum();
	}
}
