package com.example.demo.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@EqualsAndHashCode(of = {"id", "x", "y"})
@ToString(of = {"id", "x", "y"})
public class Cell {

    private Integer id;
    private final Integer x;
    private final Integer y;
    private Set<Cell> links = new HashSet<>();

    public void addLink(Cell cell) {
        links.add(cell);
    }
}