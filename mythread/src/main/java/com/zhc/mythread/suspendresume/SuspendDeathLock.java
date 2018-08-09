package com.zhc.mythread.suspendresume;

import com.zhc.mythread.suspendresume.template.SynchronizedObject;

public class SuspendDeathLock {

	public static void main(String[] args) {
		try{
			final SynchronizedObject object =  new SynchronizedObject();
			Thread thread1 = new Thread(){
				public void run(){
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(){
				public void run(){
					System.out.println("thread2启动了，但进入不了printString()方法！只打印了一个begin！");
					System.out.println("因为printString()方法被a线程锁定并且永远suspend了！");
					object.printString();
				}
			};
			thread2.start();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}
