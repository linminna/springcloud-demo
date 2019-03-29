package threads;

import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-03-29 09:24
 * <p>
 * 利用CountDownLatch(N)、CyclicBarrier(N) 实现 new CyclicBarrier(N, new Runnable() {});
 **/
public class CyclicBarrierTest3 {
    public static void main(String[] args) {
        final int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        try {
            CyclicBarrierTest3.test1(N, barrier);
            CyclicBarrierTest3.test2(N, barrier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1(int N, CyclicBarrier barrier) throws Exception {
        final CountDownLatch latch = new CountDownLatch(N);
        for (int i = 1; i <= N; i++) {
            new Thread(new Writer(barrier, latch)).start();
        }
        latch.await();
        System.out.println("线程执行完成。。");
    }

    private static void test2(int N, CyclicBarrier barrier) throws Exception {
        Vector<Thread> threadVector = new Vector<>();
        for (int i = 1; i <= N; i++) {
            Thread thread = new Thread(new CyclicBarrierTest1.Writer(barrier));
            thread.start();
            threadVector.add(thread);
        }
        for (Thread thread : threadVector) {
            thread.join();
        }
        System.out.println("线程执行完成。。");
    }

    static class Writer implements Runnable {
        CyclicBarrier barrier;
        CountDownLatch latch;

        public Writer(CyclicBarrier barrier, CountDownLatch latch) {
            this.barrier = barrier;
            this.latch = latch;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始读写数据");
            try {
                Thread.sleep(4000);
                System.out.println(name + "结束读写数据");
                latch.countDown();
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "所以线程都读取完毕，开始其他的操作");
        }
    }
}
