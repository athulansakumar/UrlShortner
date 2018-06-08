package com.athulansakumar.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={
        "com.athulansakumar"
})
@EnableMongoRepositories("com.athulansakumar.repository")
public class UrlShortnerApplication {
    public static void main(String[] args){
        SpringApplication.run(UrlShortnerApplication.class,args);
    }
}
