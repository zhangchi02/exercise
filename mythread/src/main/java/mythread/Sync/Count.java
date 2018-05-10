package mythread.Sync;

public class Count implements Runnable {
	private int count;

	public Count() {
		count = 0;
	}

	public void countAdd() {
		synchronized (this) {
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

	public void printCount() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + "  count:" + (count++));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			countAdd();
		} else if (threadName.equals("B")) {
			printCount();
		}

	}

	public static void main(String[] args) {
		Count counter = new Count();
		Thread thread1 = new Thread(counter, "A");
		Thread thread2 = new Thread(counter, "B");
		thread1.start();
		thread2.start();
		
		/*Thread thread3 = new Thread(new Count(), "A");
		Thread thread4 = new Thread(new Count(), "B");
		thread3.start();
		thread4.start();*/
	}
}
