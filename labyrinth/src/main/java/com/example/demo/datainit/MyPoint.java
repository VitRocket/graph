package com.example.demo.datainit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(of = {"x", "y"})
@RequiredArgsConstructor
public class MyPoint {

    private final Integer x;
    private final Integer y;
    private boolean print;

}