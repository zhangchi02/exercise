package com.zhc.mythread.sync.deathlock;

public class DealThread implements Runnable {
	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public void setFlag(String username) {
		this.username = username;
	}

	public void run() {
		if (username.equals("a")) {
			synchronized (lock1) {
				try {
					System.out.println("username = " + username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("��lock1->lock2����˳��ִ����");
				}
			}
		}
		if (username.equals("b")) {
			synchronized (lock2) {
				try {
					System.out.println("username = " + username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("��lock2->lock1����˳��ִ����");
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			DealThread t1 = new DealThread();
			t1.setFlag("a");
			Thread thread1 = new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread thread2 = new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
