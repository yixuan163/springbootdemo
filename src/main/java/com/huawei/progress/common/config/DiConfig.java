package com.huawei.progress.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.huawei.progress.biz.spring.service")
// 扫描包名下所有使用@Service\@Component\@Repository和@Controller的类，并注册为Bean
public class DiConfig {

}
