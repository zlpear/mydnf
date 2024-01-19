package org.zwj.mydnf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zwj.mydnf.mapper")
public class MydnfApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydnfApplication.class, args);
    }

}
