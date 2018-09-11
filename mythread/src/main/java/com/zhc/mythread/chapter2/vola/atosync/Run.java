package com.zhc.mythread.chapter2.vola.atosync;

public class Run {

	public static void main(String[] args) {
		try {
			AtoService atoService = new AtoService();
			AtoThread[] atoThread = new AtoThread[5];
			for (int i = 0; i < 5; i++) {
				atoThread[i] = new AtoThread(atoService);
			}
			for (int i = 0; i < 5; i++) {
				atoThread[i].start();
			}
			Thread.sleep(1000);
			System.out.println(atoService.aiRef.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
