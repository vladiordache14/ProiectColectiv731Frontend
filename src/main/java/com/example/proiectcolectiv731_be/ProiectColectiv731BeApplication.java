package com.example.proiectcolectiv731_be;

import com.example.proiectcolectiv731_be.pass_reset.GMailer;
import com.example.proiectcolectiv731_be.pass_reset.RandomPasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class  ProiectColectiv731BeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProiectColectiv731BeApplication.class, args);
    }

}
