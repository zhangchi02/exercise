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
					System.out.println("thread2�����ˣ������벻��printString()������ֻ��ӡ��һ��begin��");
					System.out.println("��ΪprintString()������a�߳�����������Զsuspend�ˣ�");
					object.printString();
				}
			};
			thread2.start();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}
