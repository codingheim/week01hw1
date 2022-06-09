package com.sparta.week01hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week01hwApplication {

  public static void main(String[] args) {
    SpringApplication.run(Week01hwApplication.class, args);
  }
}
