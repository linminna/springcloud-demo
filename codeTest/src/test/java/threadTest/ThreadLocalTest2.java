package threadTest;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-04-03 09:09
 **/
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        TestThreadLocal local = new TestThreadLocal();
        ThreadBean01 thread01 = new ThreadBean01("线程一", local);
        ThreadBean01 thread02 = new ThreadBean01("线程二", local);
        thread01.start();
        thread02.start();
    }
}

/**
 * 初始化threadLocal值
 */
class TestThreadLocal {
    // 定义匿名子类创建ThreadLocal的变量为什么是静态的，不管你new多少个这个类，ThreadLocal只有一个
    private static ThreadLocal<NumberBean> seqNum = new ThreadLocal<NumberBean>() {
        // 覆盖初始化方法,泛型指定什么类型就返回什么类型，方法名不变自动调用。
        public NumberBean initialValue() {
            System.out.println("初始化变量值");
            return new NumberBean();
        }
    };

    // 或取这线程的数据
    public NumberBean getNextNum() {
        return seqNum.get();
    }
}

class ThreadBean01 extends Thread {
    private TestThreadLocal te;

    public ThreadBean01(String name, TestThreadLocal te) {
        super(name);
        this.te = te;
    }

    @Override
    public void run() {
        while (te.getNextNum().getId() < 10) {
            te.getNextNum().setId(te.getNextNum().getId() + 1);
            System.out.println(this.getName() + "数字： " + te.getNextNum().getId());
        }
    }
}

class NumberBean {
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
