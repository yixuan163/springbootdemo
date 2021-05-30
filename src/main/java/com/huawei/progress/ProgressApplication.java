package com.huawei.progress;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.huawei.progress.mapper")
public class ProgressApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProgressApplication.class, args);
    }
}
