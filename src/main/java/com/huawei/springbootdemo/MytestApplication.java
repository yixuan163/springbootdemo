package com.huawei.springbootdemo;

import com.huawei.springbootdemo.bean.StudentBean;
import com.huawei.springbootdemo.common.Contans;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
@MapperScan("com.huawei.springbootdemo.mapper")
public class MytestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MytestApplication.class, args);
    }
}
