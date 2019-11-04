package com.cn.elp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cn.elp.dao")
@SpringBootApplication
public class ElpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElpApplication.class, args);
    }

}
