package mythread.notify;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChildNotifyThread implements Runnable {

    /**
     * ��־
     */
    private static final Log LOGGER = LogFactory.getLog(ChildNotifyThread.class);

    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        ChildNotifyThread.LOGGER.info("�߳�" + id +" �����ɹ���׼������ȴ�״̬");
        synchronized (ParentNotifyThread.WAIT_CHILEOBJECT) {
            try {
            	ChildNotifyThread.LOGGER.info("�߳�" + id +" �ѽ���ȴ�״̬");
                ParentNotifyThread.WAIT_CHILEOBJECT.wait();
            } catch (InterruptedException e) {
                ChildNotifyThread.LOGGER.error(e.getMessage() , e);
            }
        }

        //ִ�е����˵���̱߳������� 
        ChildNotifyThread.LOGGER.info("�߳�" + id + " �����ѣ�");
    }
}
