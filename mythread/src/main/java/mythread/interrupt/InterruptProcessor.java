package mythread.interrupt;

public class InterruptProcessor {

	public static void main(String[] args) throws Exception {
		// thread one�߳�
		Thread threadOne = new Thread(new Runnable() {
			public void run() {
				Thread currentThread = Thread.currentThread();
				// �������߳��յ�interrupt�źţ��ͻ��������֣�
				// �߳���Ҫ�������״̬�Ƿ�������Ȼ�������һ����ô�ߡ�
				while (!currentThread.isInterrupted()) {
					/*
					 * �����ӡһ�仰��˵��ѭ��һֱ������
					 * ������ʽϵͳ�в���������д���룬��Ϊû���жϣ�wait��sleep��������ѭ���Ƿǳ��ķ�CPU��Դ��
					 */
					System.out.println("Thread One һֱ�����У�");
				}

				System.out.println("thread one ����������" + currentThread.isInterrupted());
			}
		});

		// thread two�߳�
		Thread threadTwo = new Thread(new Runnable() {
			public void run() {
				Thread currentThread = Thread.currentThread();
				while (!currentThread.isInterrupted()) {
					synchronized (currentThread) {
						try {
							// ͨ��wait��������
							currentThread.wait();
						} catch (InterruptedException e) {
							e.printStackTrace(System.out);
							System.out.println("thread two �����ж��źţ��쳣������" + currentThread.isInterrupted());
							return;
						}
					}
				}

				System.out.println("thread two ����������");
			}
		});

		threadOne.start();
		threadTwo.start();
		// ������ͨ��eclipse������������϶˵㣬�Ա�֤threadOne��threadTwo���������
		// ��Ȼ��������ʹ��������ʽ��ȷ���������
		System.out.println("�����߳��������У����ڿ�ʼ�����ж��ź�");
		threadOne.interrupt();
		threadTwo.interrupt();
	}
}
