package mythread.notify;

import org.apache.log4j.BasicConfigurator;

public class ParentNotifyThread implements Runnable {
    /**
     * �������ġ�Կ�ס���Ϊÿ��ChildNotifyThread���������У�
     * ģ���������Ϊ����ChildNotifyThread����Ҫ���ж�ռ������
     */
    public static final Object WAIT_CHILEOBJECT = new Object();

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) throws Exception {
        new Thread(new ParentNotifyThread()).start();
    }

    public void run() {
        /*
         * 3������WAIT_CHILEOBJECT���������ռ���̣߳��۲����
         * */
        int maxIndex = 3;
        for(int index = 0 ; index < maxIndex ; index++) {
            ChildNotifyThread childNotify = new ChildNotifyThread();
            Thread childNotifyThread = new Thread(childNotify,"Thread"+index);
            childNotifyThread.start();
        }

        /*
         * ���������eclipse�ϵ㣬
         * �Ա㱣֤ChildNotifyThread�е�wait()�������ȱ�ִ���ˡ�
         * 
         * ��ʵ�����£�������ͨ��һ�������ͣ�����������ʽ�����������ж�
         * ������ʹ��CountDownLatch��
         * */
        synchronized (ParentNotifyThread.WAIT_CHILEOBJECT) {
        	System.out.println("�߳�" + Thread.currentThread().getId() + " ׼��ִ�л��Ѷ���");
            //ParentNotifyThread.WAIT_CHILEOBJECT.notify();
            ParentNotifyThread.WAIT_CHILEOBJECT.notifyAll();
        }

        // û�о������ʾ���壻
        // ֻ��Ϊ�˱�֤ParentNotifyThread�����˳�
        /*synchronized (ParentNotifyThread.class) {
            try {
            	System.out.println("�߳�" + Thread.currentThread().getId() + "׼������ȴ�״̬");
                ParentNotifyThread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
