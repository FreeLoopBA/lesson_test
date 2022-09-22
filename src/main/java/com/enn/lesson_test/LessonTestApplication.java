package com.enn.lesson_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableEurekaClient
@MapperScan("com.enn.lesson_test.mapper")
@SpringBootApplication
public class LessonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonTestApplication.class, args);
    }

}
