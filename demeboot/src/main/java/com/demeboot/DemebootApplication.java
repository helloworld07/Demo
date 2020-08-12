package com.demeboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.demeboot.*.dao")
@EnableAsync
public class DemebootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemebootApplication.class, args);
    }

}
