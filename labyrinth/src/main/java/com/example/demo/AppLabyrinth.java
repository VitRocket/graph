package com.example.demo;

import com.example.demo.datainit.DataInit;
import com.example.demo.domain.Cell;
import com.example.demo.domain.CellWay;
import com.example.demo.service.CellService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class AppLabyrinth implements CommandLineRunner {

    private final DataInit dataInit;
    private final CellService cellService;

    public static void main(String[] args) {
        SpringApplication.run(AppLabyrinth.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("");
        log.info("STARTING THE APPLICATION");
        dataInit.dataInit();
        //breadth-first search (поиск в ширину с путём)
        breadthFirstSearchWay();
        log.info("APPLICATION FINISHED");
    }


    private void breadthFirstSearchWay() {
        Cell cell = cellService.getByCoordinates(0, 0);
        log.info("Start: " + cell.toString());
        Cell cellEnd = cellService.getByCoordinates(4, 4);
        log.info("Finish: " + cellEnd.toString());

        log.info("");
        log.info("search in: " + cell);
        CellWay manager = cellService.findPostByFriendsWay(cell, cellEnd);
        log.info("Result: " + manager);
        printWay(manager);
        System.out.println();


    }

    private void printWay(CellWay userWay) {
        if (userWay.getFather() != null) {
            printWay(userWay.getFather());
            System.out.print(" -> " + userWay.getX() + "." + userWay.getY());
        } else {
            System.out.print(userWay.getX() + "." + userWay.getY());
        }
    }
}
