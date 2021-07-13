package com.huawei.progress;

import com.huawei.progress.biz.model.StudentModel;
import com.huawei.progress.biz.model.UserModel;
import com.huawei.progress.common.Contans;
import com.huawei.progress.biz.common.service.UserService;
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
public class ProgressApplicationTest {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        UserModel userModel = userService.loginIn("test1", "123");
        System.out.println("该用户ID为：");
        System.out.println(userModel.getId());
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

        List<StudentModel> studentModels = new ArrayList<>(16);
        studentModels.add(new StudentModel("1", "张三", 18, "male", 88));
        studentModels.add(new StudentModel("2", "李四", 17, "male", 60));
        studentModels.add(new StudentModel("3", "王五", 18, "male", 100));
        studentModels.add(new StudentModel("4", "赵六", 20, "male", 10));
        studentModels.add(new StudentModel("5", "董七", 14, "female", 95));
        studentModels.add(new StudentModel("6", "幺八", 21, "male", 55));
        studentModels.add(new StudentModel("7", "老九", 20, "female", 66));
        studentModels.add(new StudentModel("8", "小明", 18, "male", 100));
        studentModels.add(new StudentModel("9", "小红", 22, "female", 95));
        studentModels.add(new StudentModel("10", "小张", 25, "male", 90));
        studentModels.forEach(System.out::println);

        // 过滤出成绩100分的学生
        System.out.println("过滤出成绩100分的学生");
        List<StudentModel> students1 =
                studentModels.stream().filter(studentModel -> studentModel.getScore() == 100).collect(Collectors.toList());
        students1.forEach(System.out::println);

        System.out.println("串行流，匹配第一个");
        // 串行流，匹配第一个
        Optional<StudentModel> studentOptional =
                studentModels.stream().filter(studentModel -> studentModel.getAge() >= 20).findFirst();
        if (studentOptional.isPresent()) {
            StudentModel studentModel = studentOptional.get();
            System.out.println(studentModel);
        }
// 上面输出语句可简写如下
// studentOptional.ifPresent(System.out::println);
        System.out.println("行流，匹配任意一个，findAny一般用于并行流");
// 并行流，匹配任意一个，findAny一般用于并行流
        Optional<StudentModel> studentOptiona2 =
                studentModels.parallelStream().filter(studentModel -> studentModel.getAge() >= Contans.INDEX_TWENTY).findAny();
        studentOptiona2.ifPresent(System.out::println);
        System.out.println("匹配 match");
// 是否存在100分的学生
        boolean anyMatch = studentModels.stream().anyMatch(studentModel -> studentModel.getScore() == 100);
// 是否全部学生都100分
        boolean allMatch = studentModels.stream().allMatch(studentModel -> studentModel.getScore() == 100);
// 是否全部学生都没有100分
        boolean noneMatch = studentModels.stream().noneMatch(studentModel -> studentModel.getScore() == 100);
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);

        // 获取每个学生的姓名
        List<String> studentNames =
                studentModels.stream().map(StudentModel::getName).collect(Collectors.toList());
        System.out.println(studentNames);

        // 获取每个学生的姓名+","+sex组成新的字符串

        List<String> stringStream = studentModels.stream().map
                (studentModel -> (studentModel.getName() + "," + studentModel.getSex())).
                collect(Collectors.toList());
        boolean contains = stringStream.contains("王五,male");
        log.info("[mytest]:contains={}", contains);
        System.out.println("测试map映射拼接1：" + stringStream);

        List<String> stringStream3 = studentModels.stream().map(
                studentModel -> (studentModel.getName() + "," + studentModel.getSex())).flatMap(
                s -> Arrays.stream(s.split(","))).collect(Collectors.toList());
        System.out.println("测试map映射拼接3：" + stringStream3);
        ;
        boolean contains3 = stringStream3.contains("王五");
        log.info("[mytest]={}", contains3);

        // 每个学生的成绩加10分
        List<Double> studentScores = studentModels.stream().map(studentModel -> studentModel.getScore() + 10)
                .collect(Collectors.toList());
        System.out.println(studentScores);

        List<String> listString = Arrays.asList("a-b-c-d", "g-h-i");
        List<String> list1 = listString.stream().flatMap(s -> Arrays.stream(s.split("-"))).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("imit方法用于获取指定数量的流。例如下面演示取出学习成绩大于70的5个人");
        // limit方法用于获取指定数量的流。例如下面演示取出学习成绩大于70的5个人
        List<StudentModel> students2 = studentModels.stream().filter(studentModel -> studentModel.getScore() > 70)
                .limit(5).collect(Collectors.toList());
        students2.forEach(System.out::println);
        System.out.println("跳过第一个再取2个");
// 跳过第一个再取2个
        List<StudentModel> students8 = studentModels.stream().skip(1).limit(2).collect(Collectors.toList());
        students8.forEach(System.out::println);
        System.out.println("获取5个int随机数,按从小到大排序");
// 获取5个int随机数,按从小到大排序
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);

        System.out.println("成绩排序");
        // 按成绩升序
        List<StudentModel> students3 = studentModels.stream().sorted(Comparator.comparing(StudentModel::getScore))
                .collect(Collectors.toList());
        System.out.println("按成绩升序");
        students3.forEach(System.out::println);
// 按成绩降序
        List<StudentModel> students4 =
                studentModels.stream().sorted(Comparator.comparing(StudentModel::getScore).reversed())
                        .collect(Collectors.toList());
        System.out.println("按成绩降序");
        students4.forEach(System.out::println);
// 按成绩升序，再按年龄升序
        List<StudentModel> students5 = studentModels.stream()
                .sorted(Comparator.comparing(StudentModel::getScore).thenComparing(StudentModel::getAge))
                .collect(Collectors.toList());
        System.out.println("按成绩升序，再按年龄升序");
        students5.forEach(System.out::println);
// 按成绩升序，再按年龄降序
        List<StudentModel> students6 = studentModels.stream().sorted((s1, s2) -> {
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
    public void testArrayList() { // 创建1个空列表

        List<String> arrlist = new ArrayList<>();

        // 添加测试数据

        arrlist.add("老九161");
        arrlist.add("李四");
        arrlist.add("小张");
        arrlist.add("张三");
        arrlist.add("小红");

        // 列表是否包含元素 161

        boolean res = arrlist.contains("老九161");

        if (res) {

            System.out.println("包含");

        } else {

            System.out.println("不包含");

        }
    }

}
