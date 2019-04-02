/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-04-02 17:30
 * <p>
 * 打印结果显示：同一个线程 获取到的值是相同的
 **/
public class ThreadLocalTest {

    public static ThreadLocal<String> local = new ThreadLocal<String>();//声明静态的threadlocal变量
    public static ThreadLocal<String> local2 = new ThreadLocal<String>();//声明静态的threadlocal变量

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            TestThread testThread = new TestThread();//创建5个线程
            new Thread(testThread).start();
        }
    }
}

class TestThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocalTest.local.set(Thread.currentThread().getId() + ":" + System.currentTimeMillis());
        ThreadLocalTest.local2.set(Thread.currentThread().getId() + "");
        firstStep();
        try {
            Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secondStep();
        try {
            Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thirdStep();
        try {
            Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fourthStep();
        try {
            Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fStep();
    }

    public void firstStep() {
        System.out.println(ThreadLocalTest.local.get().toString() + ":first step");//获取本线程的threadlocal变量值并打印
    }

    public void secondStep() {
        System.out.println(ThreadLocalTest.local.get().toString() + ":second step");
    }

    public void thirdStep() {
        System.out.println(ThreadLocalTest.local.get().toString() + ":third step");
    }

    public void fourthStep() {
        System.out.println(ThreadLocalTest.local.get().toString() + ":fourth step");
    }

    public void fStep() {
        System.out.println(ThreadLocalTest.local.get().toString() + ":fifth step");
    }
}