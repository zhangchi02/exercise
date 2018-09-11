package com.zhc.mythread.chapter1.interrupt;

public class ExceptionInterrupted extends Thread {
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.isInterrupted()) {
					System.out.println("�Ѿ���ֹͣ״̬�ˣ���Ҫ�˳�ִ���ˣ�");
					// break;
					throw new InterruptedException();
				}
				System.out.println("i= " + (i + 1));
			}
			System.out.println("����for���棬����ִ�У�����");
		} catch (InterruptedException e) {
			System.out.println("����run()�����е�catch��" + this.isInterrupted());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ExceptionInterrupted fi = new ExceptionInterrupted();
			fi.start();
			Thread.sleep(2000);
			fi.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
