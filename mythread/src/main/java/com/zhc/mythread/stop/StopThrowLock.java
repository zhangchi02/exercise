package com.zhc.mythread.stop;

import com.zhc.mythread.stop.template.SynchronizedObject;

public class StopThrowLock extends Thread {
	private SynchronizedObject object;

	public StopThrowLock(SynchronizedObject object) {
		super();
		this.object = object;
	}

	public void run() {
		object.printString("b", "bb");
	}

	public static void main(String[] args) {
		try {
			SynchronizedObject object = new SynchronizedObject();
			StopThrowLock stl = new StopThrowLock(object);
			stl.start();
			Thread.sleep(500);
			stl.stop();
			System.out.println(object.getUsername() + " " + object.getPassword());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
