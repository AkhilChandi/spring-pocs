package com.example.ssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSslApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSslApplication.class, args);
    }

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello World!...";
    }

}
