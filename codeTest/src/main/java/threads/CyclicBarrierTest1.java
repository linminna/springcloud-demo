package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1 {

    public static void main(String[] args) {
        final int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 1; i <= N; i++) {
            new Thread(new Writer(barrier)).start();
        }
        System.out.println("线程结束！！");
    }

    static class Writer implements Runnable {
        CyclicBarrier barrier;

        public Writer(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始读写数据");
            try {
                Thread.sleep(4000);
                System.out.println(name + "结束读写数据");
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
