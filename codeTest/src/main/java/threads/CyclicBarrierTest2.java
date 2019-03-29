package threads;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
    
    public static void main(String[] args) {
        final int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {//在所有线程操作完后 进行的额外操作
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name + "barrier Runnable");
            }
        });
        for (int i = 1; i <= N; i++) {
            new Thread(new CyclicBarrierTest1.Writer(barrier)).start();
        }
    }
}
