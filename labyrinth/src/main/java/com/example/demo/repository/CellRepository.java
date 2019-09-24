package com.example.demo.repository;

import com.example.demo.domain.Cell;

import java.util.List;

public interface CellRepository {
    Cell save(Cell cell);
    List<Cell> findAll();
    Cell findByCoordinates(int x, int y);
}