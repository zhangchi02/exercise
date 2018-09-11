package com.zhc.mythread.chapter2.sync.lockextend;

public class ParentI {
	public int i = 10;

	synchronized public void operateIParentMethod() {
		try {
			i--;
			System.out.println("parent print i = " + i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
