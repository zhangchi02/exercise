package mythread.Sync;

public class SyncStaticThread implements Runnable {

	private static int count;

	public SyncStaticThread() {
		count = 0;
	}

	public synchronized void run() {
		method();
	}

	public synchronized static void method() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SyncStaticThread syncThread1 = new SyncStaticThread();
		SyncStaticThread syncThread2 = new SyncStaticThread();
		Thread thread1 = new Thread(syncThread1, "SyncStaticThread1");
		Thread thread2 = new Thread(syncThread2, "SyncStaticThread2");
		thread1.start();
		thread2.start();
	}
}
