import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-05-09 09:31
 **/
public class ReduceTest {

    public static void main(String[] args) {
        ReduceTest reduceTest = new ReduceTest();
        //reduceTest.reduceList();
        //reduceTest.reduceList2();

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        //求集合元素只和
        //Integer result = stream.reduce(0, Integer::sum);
        //System.out.println(result);
        //求和  stream.reduce()不能连续调用，可通过 numbers.stream()来调用
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);
        //stream.reduce(Integer::max).ifPresent(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        numbers.stream().reduce((i, j) -> i + j).ifPresent(System.out::println);
        int result2 = numbers.stream().filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
        Optional.of(result2).ifPresent(System.out::println);

        List<Integer> doubleNumbers = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        System.out.println(doubleNumbers);

        String result = Arrays.asList("str1", "str2", "str3")
                .stream()
                .filter(str -> str.contains("3"))
                .map(str -> str.toUpperCase())
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("join: " + result);
    }

    public void reduceList() {
        List<Student> list = getStudents();
        //使用Reduce 将所有的所有的成绩进行加和
        Optional<Score> totalScore = list.stream()
                .map(Student::getScore)
                .reduce((x, y) -> x.add(y));
        System.out.println("--reduceList未初始化--" + totalScore.get().getPoint());
    }

    public void reduceList2() {
        List<Student> list = getStudents();
        Student student = getStudent();
        //使用Reduce 求 list 、student 的总成绩之和
        Score scoreSum = list.stream()
                .map(Student::getScore)
                .reduce(new Score(0), (x, y) -> x.add(y)); //相当于加了一个初始值
        System.out.println("--reduceList2初始化--" + scoreSum.getPoint());
    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(4);
        Score score = new Score();
        score.setCourseName("English");
        score.setPoint(0);
        student.setScore(score);
        return student;
    }

    private List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student stu = new Student();
            Score score = new Score();
            score.setPoint(80);
            score.setCourseName("English");
            stu.setId(i);
            stu.setScore(score);
            list.add(stu);
        }
        return list;
    }

}

class Student {
    private Integer id;

    //课程分数
    private Score score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

class Score {
    //分数
    private Integer point;

    //课程名称
    private String courseName;

    public Score() {
    }

    public Score(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public Score add(Score other) {
        this.point += other.getPoint();
        return this;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}