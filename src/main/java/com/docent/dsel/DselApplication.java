package com.docent.dsel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DselApplication {

    public static void main(String[] args) {
        SpringApplication.run(DselApplication.class, args);
    }

}
