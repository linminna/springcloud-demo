package threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLautchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("子线程1执行开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程1执行结束");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("子线程2执行开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程2执行结束");
            latch.countDown();
        }).start();

        try {
            latch.await();
            System.out.println("所有子线程执行完毕了。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
