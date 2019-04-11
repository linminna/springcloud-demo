package strings;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-04-11 17:16
 **/
public class StringBufferTest {

    public static void main(String[] args) {
        StringBufferTest testFinal = new StringBufferTest();
        StringBuffer buffer = new StringBuffer("hello");
        //testFinal.changeValue(buffer);
        testFinal.changeValue2(buffer);
        System.out.println(buffer);
    }

    public void changeValue(final StringBuffer buffer) {
        //buffer无法重新指向另一个对象
        //buffer = new StringBuffer("hi");
        buffer.append("world");
        System.out.println(buffer);
    }

    public void changeValue2(StringBuffer buffer) {
        //buffer重新指向另一个对象
        buffer = new StringBuffer("hi");
        buffer.append("world");
        System.out.println(buffer);
    }
}
