package com.media.service.copic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CopicApplication.class, args);
    }

}
