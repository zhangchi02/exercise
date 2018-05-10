package mythread.Sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class SyncThread2 implements Runnable {

	/**
	 * ��־
	 */
	private static final Log LOGGER = LogFactory.getLog(SyncThread2.class);

	private Integer value;

	private static Integer NOWVALUE;

	static {
		BasicConfigurator.configure();
	}

	public SyncThread2(int value) {
		this.value = value;
	}

	/**
	 * ��������ʵ����������м��
	 */
	/*
	 * private synchronized void doOtherthing() { NOWVALUE = this.value;
	 * LOGGER.info("��ǰNOWVALUE��ֵ��" + NOWVALUE); }
	 */
	private void doOtherthing() {
		synchronized (SyncThread2.class) {
			NOWVALUE = this.value;
			LOGGER.info("��ǰNOWVALUE��ֵ��" + NOWVALUE);
		}
	}

	public void run() {
		Thread currentThread = Thread.currentThread();
		Long id = currentThread.getId();
		this.doOtherthing();
	}

	public static void main(String[] args) throws Exception {
		Thread syncThread1 = new Thread(new SyncThread2(10));
		Thread syncThread2 = new Thread(new SyncThread2(100));

		syncThread1.start();
		syncThread2.start();
	}
}