import java.util.Optional;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-01-14 10:23
 **/
public class OptionalTest {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> a = Optional.ofNullable(value1); // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> b = Optional.of(value2);   // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        OptionalTest optionalTest = new OptionalTest();
        System.out.println(optionalTest.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值存在: " + a.isPresent());  // Optional.isPresent - 判断值是否存在
        System.out.println("第二个参数值存在: " + b.isPresent());
        Integer value1 = a.orElse(new Integer(0)); // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value2 = b.get(); //Optional.get - 获取值，值需要存在
        return value1 + value2;
    }

}
