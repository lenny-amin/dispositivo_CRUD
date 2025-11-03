package com.example.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example", exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@EntityScan("com.example.dispositivos.Models")
@EnableJpaRepositories("com.example.dispositivos.Repository")

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}