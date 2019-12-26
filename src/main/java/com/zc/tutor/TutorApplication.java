package com.zc.tutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@EnableCaching
@EnableWebMvc
public class TutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorApplication.class, args);
    }



}
