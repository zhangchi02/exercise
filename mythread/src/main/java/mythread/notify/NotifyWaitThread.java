package mythread.notify;

public class NotifyWaitThread {

	public static void main(String[] args) {
		final Object object = new Object();
		Thread thread1 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("thread1 start!");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread1 end!");
				}
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("thread2 start!");
					object.notify();
					System.out.println("thread2 end!");
				}
			}
		};
		Thread thread3 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("thread3 start!");
					object.notify();
					System.out.println("thread3 end!");
				}
			}
		};
		Thread thread4 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("thread4 start!");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread4 end!");
				}
			}
		};
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
