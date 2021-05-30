package com.huawei.progress;

import com.huawei.progress.bean.StudentBean;
import com.huawei.progress.bean.UserBean;
import com.huawei.progress.common.Contans;
import com.huawei.progress.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MytestApplicationTest {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("test1", "123");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }

    @Test
    public void myTestStream() {
        // 创建集合
        List<String> list = Arrays.asList("张三", "李四", "王五");
// 创建一个串行流
        Stream<String> stream = list.stream();
// 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();

        // 创建数组
        String[] persons = {"张三", "李四", "王五"};
// 创建一个串行流
        Stream<String> stream1 = Arrays.stream(persons);
// 创建一个并行流
        Stream<String> parallelStream1 = Arrays.stream(persons).parallel();

        Stream<String> stream2 = Stream.of("张三", "李四", "王五");

// 输出5个奇数 1 3 5 7 9
        Stream<Integer> stream3 = Stream.iterate(1, x -> x + 2).limit(5);
        stream3.forEach(System.out::println);

// 生成2个UUID
        Stream<UUID> stream4 = Stream.generate(UUID::randomUUID).limit(2);
        stream4.forEach(System.out::println);

        List<StudentBean> studentBeans = new ArrayList<>(16);
        studentBeans.add(new StudentBean("1", "张三", 18, "male", 88));
        studentBeans.add(new StudentBean("2", "李四", 17, "male", 60));
        studentBeans.add(new StudentBean("3", "王五", 18, "male", 100));
        studentBeans.add(new StudentBean("4", "赵六", 20, "male", 10));
        studentBeans.add(new StudentBean("5", "董七", 14, "female", 95));
        studentBeans.add(new StudentBean("6", "幺八", 21, "male", 55));
        studentBeans.add(new StudentBean("7", "老九", 20, "female", 66));
        studentBeans.add(new StudentBean("8", "小明", 18, "male", 100));
        studentBeans.add(new StudentBean("9", "小红", 22, "female", 95));
        studentBeans.add(new StudentBean("10", "小张", 25, "male", 90));
        studentBeans.stream().forEach(System.out::println);

        // 过滤出成绩100分的学生
        System.out.println("过滤出成绩100分的学生");
        List<StudentBean> students1 =
                studentBeans.stream().filter(studentBean -> studentBean.getScore() == 100).collect(Collectors.toList());
        students1.forEach(System.out::println);

        System.out.println("串行流，匹配第一个");
        // 串行流，匹配第一个
        Optional<StudentBean> studentOptional =
                studentBeans.stream().filter(studentBean -> studentBean.getAge() >= 20).findFirst();
        if (studentOptional.isPresent()) {
            StudentBean studentBean = studentOptional.get();
            System.out.println(studentBean);
        }
// 上面输出语句可简写如下
// studentOptional.ifPresent(System.out::println);
        System.out.println("行流，匹配任意一个，findAny一般用于并行流");
// 并行流，匹配任意一个，findAny一般用于并行流
        Optional<StudentBean> studentOptiona2 =
                studentBeans.parallelStream().filter(studentBean -> studentBean.getAge() >= Contans.INDEX_TWENTY).findAny();
        studentOptiona2.ifPresent(System.out::println);
        System.out.println("匹配 match");
// 是否存在100分的学生
        boolean anyMatch = studentBeans.stream().anyMatch(studentBean -> studentBean.getScore() == 100);
// 是否全部学生都100分
        boolean allMatch = studentBeans.stream().allMatch(studentBean -> studentBean.getScore() == 100);
// 是否全部学生都没有100分
        boolean noneMatch = studentBeans.stream().noneMatch(studentBean -> studentBean.getScore() == 100);
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);

        // 获取每个学生的姓名
        List<String> studentNames =
                studentBeans.stream().map(StudentBean::getName).collect(Collectors.toList());
        System.out.println(studentNames);

        // 获取每个学生的姓名+","+sex组成新的字符串

        List<String> stringStream = studentBeans.stream().map
                (studentBean -> (studentBean.getName() + "," + studentBean.getSex())).
                collect(Collectors.toList());
        boolean contains = stringStream.contains("王五,male");
        log.info("[mytest]:contains={}", contains);
        System.out.println("测试map映射拼接1：" + stringStream);

        List<String> stringStream3 = studentBeans.stream().map(
                studentBean -> (studentBean.getName() + "," + studentBean.getSex())).flatMap(
                s -> Arrays.stream(s.split(","))).collect(Collectors.toList());
        System.out.println("测试map映射拼接3：" + stringStream3);
        ;
        boolean contains3 = stringStream3.contains("王五");
        log.info("[mytest]={}", contains3);

// 每个学生的成绩加10分
        List<Double> studentScores = studentBeans.stream().map(studentBean -> studentBean.getScore() + 10)
                .collect(Collectors.toList());
        System.out.println(studentScores);

        List<String> listString = Arrays.asList("a-b-c-d", "g-h-i");
        List<String> list1 = listString.stream().flatMap(s -> Arrays.stream(s.split("-"))).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("imit方法用于获取指定数量的流。例如下面演示取出学习成绩大于70的5个人");
        // limit方法用于获取指定数量的流。例如下面演示取出学习成绩大于70的5个人
        List<StudentBean> students2 = studentBeans.stream().filter(studentBean -> studentBean.getScore() > 70)
                .limit(5).collect(Collectors.toList());
        students2.forEach(System.out::println);
        System.out.println("跳过第一个再取2个");
// 跳过第一个再取2个
        List<StudentBean> students8 = studentBeans.stream().skip(1).limit(2).collect(Collectors.toList());
        students8.forEach(System.out::println);
        System.out.println("获取5个int随机数,按从小到大排序");
// 获取5个int随机数,按从小到大排序
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);

        System.out.println("成绩排序");
        // 按成绩升序
        List<StudentBean> students3 = studentBeans.stream().sorted(Comparator.comparing(StudentBean::getScore))
                .collect(Collectors.toList());
        System.out.println("按成绩升序");
        students3.forEach(System.out::println);
// 按成绩降序
        List<StudentBean> students4 =
                studentBeans.stream().sorted(Comparator.comparing(StudentBean::getScore).reversed())
                        .collect(Collectors.toList());
        System.out.println("按成绩降序");
        students4.forEach(System.out::println);
// 按成绩升序，再按年龄升序
        List<StudentBean> students5 = studentBeans.stream()
                .sorted(Comparator.comparing(StudentBean::getScore).thenComparing(StudentBean::getAge))
                .collect(Collectors.toList());
        System.out.println("按成绩升序，再按年龄升序");
        students5.forEach(System.out::println);
// 按成绩升序，再按年龄降序
        List<StudentBean> students6 = studentBeans.stream().sorted((s1, s2) -> {
            if (s1.getScore() != s2.getScore()) {
                return (int) (s1.getScore() - s2.getScore());
            } else {
                return (s2.getAge() - s1.getAge());
            }
        }).collect(Collectors.toList());
        System.out.println("按成绩升序，再按年龄降序");
        students6.forEach(System.out::println);

        System.out.println("去重");
        List<String> list2 = Arrays.asList("a", "b", "a", "c", "f", "e", "f");
        List<String> list3 = list2.stream().distinct().collect(Collectors.toList());
        Set<String> stringSet = list2.stream().collect(Collectors.toSet()); // list转set也可以达到去重效果
        System.out.println(list3);
        System.out.println(stringSet);

    }

    @Test
    private static void testArrayList() { // 创建1个空列表

        List<String> arrlist = new ArrayList<>();

        // 添加测试数据

        arrlist.add("老九161");
        arrlist.add("李四");
        arrlist.add("小张");
        arrlist.add("张三");
        arrlist.add("小红");

        // 列表是否包含元素 161

        boolean res = arrlist.contains("老九161");

        if (res == true) {

            System.out.println("包含");

        } else {

            System.out.println("不包含");

        }
    }

}
