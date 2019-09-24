package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CellWay extends Cell {

    private CellWay father;

    public CellWay(Integer x, Integer y) {
        super(x, y);
    }
}