package mythread.Sync;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThreadLock {

    /**
     * ���������Ķ���
     */
    private static final Object WAIT_OBJECT = new Object();

    /**
     * ��־�������û��log4j����ʹ��System.out
     */
    private static final Log LOGGER = LogFactory.getLog(ThreadLock.class);

    /**
     * ͵�����Ұ��쳣ȫ���׳��ˡ���ʽϵͳ��Ҫ��ô��Ŷ����
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                // ���'������'״̬��
                synchronized (ThreadLock.WAIT_OBJECT) {
                    ThreadLock.LOGGER.info("����һЩ���顣������");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                // ���'������'״̬��
                synchronized (ThreadLock.WAIT_OBJECT) {
                    ThreadLock.LOGGER.info("������һЩ���顣������");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}