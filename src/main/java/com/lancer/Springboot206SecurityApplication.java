package com.lancer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.lancer"})
@MapperScan("com.lancer.dao")
public class Springboot206SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot206SecurityApplication.class, args);
    }

}
