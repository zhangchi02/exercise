package mythread.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * ����߳���������join��ִ��
 * @author yinwenjie
 */
public class JoinThread implements Runnable {

    static {
        BasicConfigurator.configure();
    }

    /**
     * ��־
     */
    private static Log LOGGER = LogFactory.getLog(JoinThread.class);

    public static void main(String[] args) throws Exception {
        /*
         * ����һ�����߳�joinThread��Ȼ��ȴ����߳�joinThread������ɺ�
         * ����߳��ټ�������
         * */
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        Thread joinThread = new Thread(new JoinThread());
        joinThread.start();

        try {
            // �ȴ���ֱ��joinThreadִ����ɺ�main�̲߳ż���ִ��
        	joinThread.join();
            //joinThread.join(2000);
            JoinThread.LOGGER.info("�߳�" + id + "����ִ�У�");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        JoinThread.LOGGER.info("�߳�" + id + "�����ɹ���׼������ȴ�״̬��5�룩");

        // ʹ��sleep������ģ������߳�ִ��ҵ�����Ĺ���
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }

        //ִ�е����˵���̱߳�������
        JoinThread.LOGGER.info("�߳�" + id + "ִ����ɣ�");
    }
}
