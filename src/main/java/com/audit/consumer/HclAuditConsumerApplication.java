package com.audit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class HclAuditConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HclAuditConsumerApplication.class, args);
    }

}
