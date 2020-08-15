package com.example.adminteacher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@MapperScan(basePackages ={"com.example.adminteacher.mapper"})
public class AdminteacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminteacherApplication.class, args);
    }

}
