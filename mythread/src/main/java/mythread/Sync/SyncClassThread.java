package mythread.Sync;

public class SyncClassThread implements Runnable {

	private static int count;

	public SyncClassThread() {
		count = 0;
	}

	public synchronized void run() {
		method();
	}

	public static void method() {
		synchronized(SyncClassThread.class){
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		SyncClassThread syncThread1 = new SyncClassThread();
		SyncClassThread syncThread2 = new SyncClassThread();
		Thread thread1 = new Thread(syncThread1, "SyncStaticThread1");
		Thread thread2 = new Thread(syncThread2, "SyncStaticThread2");
		thread1.start();
		thread2.start();
	}
}
