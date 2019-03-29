package threads;

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
        final CountDownLatch latch = new CountDownLatch(N);
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 1; i <= N; i++) {
            new Thread(new Writer(barrier, latch)).start();
        }
        try {
            latch.await();
            System.out.println("程序结束！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
