package com.example.demo;

import com.example.demo.datainit.DataInit;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.domain.UserWay;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class AppGraph implements CommandLineRunner {

    private final DataInit dataInit;
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AppGraph.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("");
        log.info("STARTING THE APPLICATION");
        dataInit.dataInit();
        //breadth-first search (поиск в ширину)
        breadthFirstSearch();
        //breadth-first search (поиск в ширину с путём)
        breadthFirstSearchWay();
        log.info("APPLICATION FINISHED");
    }

    private void breadthFirstSearch() {
        log.info("");
        log.info("----- breadth-first search (поиск в ширину) -----");
        String userName = "Vitalii";
        log.info("search in: " + userName);
        User user = userService.getByName(userName);
        log.info("done: " + user.toString());
        log.info("search : " + Post.MANAGER + " in the friends of " + userName);
        User manager = userService.findPostByFriends(user, Post.MANAGER);
        log.info("Result: " + manager);


        userName = "Tom";
        log.info("search in: " + userName);
        user = userService.getByName(userName);
        log.info("done: " + user.toString());
        log.info("search : " + Post.MANAGER + " in the friends of " + userName);
        manager = userService.findPostByFriends(user, Post.MANAGER);
        log.info("Result: " + manager);
        log.info("----- breadth-first search (поиск в ширину) -----");
        log.info("");
    }

    private void breadthFirstSearchWay() {
        log.info("");
        log.info("----- breadth-first search with way (поиск в ширину с путём) -----");
        String userName = "Tom";
        log.info("search in: " + userName);
        User user = userService.getByName(userName);
        log.info("done: " + user.toString());
        log.info("search : " + Post.MANAGER + " in the friends of " + userName);
        UserWay manager = userService.findPostByFriendsWay(user, Post.MANAGER);
        log.info("Result: " + manager.getId() + ":" + manager.getName());
        log.info("Way: " + wayToString(manager));
        log.info("----- breadth-first search with way (поиск в ширину с путём) -----");
        log.info("");
    }

    private String wayToString(UserWay userWay) {
        if (userWay.getFather() != null) {
            return wayToString(userWay.getFather()) + " -> " + userWay.getName();
        } else {
            return userWay.getName();
        }
    }
}
