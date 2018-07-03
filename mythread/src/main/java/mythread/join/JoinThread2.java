package mythread.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * ����߳���������join��ִ��
 * 
 * @author yinwenjie
 */
public class JoinThread2 implements Runnable {

	private static int i = 10;
	static {
		BasicConfigurator.configure();
	}

	/**
	 * ��־
	 */
	private static Log LOGGER = LogFactory.getLog(JoinThread2.class);

	public static void main(String[] args) throws Exception {
		/*
		 * ����һ�����߳�joinThread��Ȼ��ȴ����߳�joinThread������ɺ� ����߳��ټ�������
		 * 
		 */
		Thread currentThread = Thread.currentThread();
		long id = currentThread.getId();
		Thread joinThread = new Thread(new JoinThread2());

		Thread thread = new Thread() {
			public void run() {
				synchronized (JoinThread2.class) {
					Thread currentThread = Thread.currentThread();
					long id1 = currentThread.getId();
					JoinThread2.LOGGER.info("�߳�" + id1 + "�����ɹ���" + i);
					i = 30;
					JoinThread2.LOGGER.info("�߳�" + id1 + "ִ����ɣ�" + i);
				}
			}
		};
		joinThread.start();
		thread.start();
		try {
			// �ȴ���ֱ��joinThreadִ����ɺ�main�̲߳ż���ִ��
			//joinThread.join();
			joinThread.join(2000);
			thread.join();
			JoinThread2.LOGGER.info("�߳�" + id + "����ִ�У�" + i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		synchronized (JoinThread2.class) {
			Thread currentThread = Thread.currentThread();
			long id2 = currentThread.getId();
			JoinThread2.LOGGER.info("�߳�" + id2 + "�����ɹ���׼������ȴ�״̬��5�룩" + i);

			// ʹ��sleep������ģ������߳�ִ��ҵ�����Ĺ���
			try {
				Thread.sleep(5000);
				i = 20;
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}

			// ִ�е����˵���̱߳�������
			JoinThread2.LOGGER.info("�߳�" + id2 + "ִ����ɣ�" + i);
		}
	}
}
