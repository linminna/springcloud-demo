import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-01-14 14:46
 **/
public class StreamTest {

    public static void main(String[] args) {
        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("列表: " + strings);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);
        //parallelStream 是流并行处理程序的代替方法
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("parallelStream 空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        //Collectors可用于返回列表或字符串
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);

        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        Random random = new Random();
        //limit 方法用于获取指定数量的流
        //Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
        random.ints(0, 100).limit(10).sorted().forEach(e -> {
            System.out.print(e + "\t");//System.out::print 方法引用
        });
        System.out.println("------------");

        new StreamTest().testGroupingBy();
    }

    /**
     * 分组统计
     */
    public void testGroupingBy() {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("black", 18));
        appleList.add(new Apple("red", 11));
        appleList.add(new Apple("blue", 12));
        appleList.add(new Apple("red", 15));
        appleList.add(new Apple("red", 1));
        appleList.add(new Apple("blue", 16));
        Map<String, List<Apple>> appMap =
                appleList.stream().filter((Apple a) -> a.getWeight() > 10).collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(appMap.toString());
        Map<String, Long> countMap = appleList.stream().collect(Collectors.groupingBy(Apple::getColor,
                Collectors.counting()));
        System.out.println(countMap.toString());
        Map<String, Integer> sumMap = appleList.stream().collect(Collectors.groupingBy(Apple::getColor,
                Collectors.summingInt(Apple::getWeight)));
        System.out.println(sumMap.toString());

    }

    class Apple {
        private String color;//颜色
        private Integer weight; //重量

        public Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
