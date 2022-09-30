package com.xian.garbage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xian.garbage.dao")
@SpringBootApplication
public class GarbageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarbageApplication.class, args);
    }

}
