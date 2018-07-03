package mythread.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * 这个线程用来测试join的执行
 * 
 * @author yinwenjie
 */
public class JoinThread2 implements Runnable {

	private static int i = 10;
	static {
		BasicConfigurator.configure();
	}

	/**
	 * 日志
	 */
	private static Log LOGGER = LogFactory.getLog(JoinThread2.class);

	public static void main(String[] args) throws Exception {
		/*
		 * 启动一个子线程joinThread，然后等待子线程joinThread运行完成后 这个线程再继续运行
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
					JoinThread2.LOGGER.info("线程" + id1 + "启动成功！" + i);
					i = 30;
					JoinThread2.LOGGER.info("线程" + id1 + "执行完成！" + i);
				}
			}
		};
		joinThread.start();
		thread.start();
		try {
			// 等待，直到joinThread执行完成后，main线程才继续执行
			//joinThread.join();
			joinThread.join(2000);
			thread.join();
			JoinThread2.LOGGER.info("线程" + id + "继续执行！" + i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		synchronized (JoinThread2.class) {
			Thread currentThread = Thread.currentThread();
			long id2 = currentThread.getId();
			JoinThread2.LOGGER.info("线程" + id2 + "启动成功，准备进入等待状态（5秒）" + i);

			// 使用sleep方法，模型这个线程执行业务代码的过程
			try {
				Thread.sleep(5000);
				i = 20;
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}

			// 执行到这里，说明线程被唤醒了
			JoinThread2.LOGGER.info("线程" + id2 + "执行完成！" + i);
		}
	}
}
