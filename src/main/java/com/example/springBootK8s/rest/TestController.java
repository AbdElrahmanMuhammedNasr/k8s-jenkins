package com.example.springBootK8s.rest;


import com.example.springBootK8s.domain.Message;
import com.example.springBootK8s.domain.User;
import com.example.springBootK8s.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    private UserRepo userRepo;

    public TestController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Value("${TEST.NAME}")
    private String appName;
    @GetMapping(value = "/msg")
    public ResponseEntity<Object> getMessage(){
        Message createdMessage = new Message();
        createdMessage.setAppName(appName==null ? "EMPTY" : appName);
        logger.info("create message "+ createdMessage.toString() +" in time "+Instant.now());
        return ResponseEntity.ok().body(createdMessage);
    }

    @GetMapping(value = "/get-user")
    public ResponseEntity<Object> getUser(){
        for (int i = 0; i < 5; i++) {
            User user = new User();
            userRepo.save(user);
        }
        return ResponseEntity.ok().body(userRepo.findAll());
    }

}
