package com.example.demo.repository;

import com.example.demo.domain.Cell;

public interface CellRepository {

    Cell save(Cell cell);

    Cell findByCoordinates(int x, int y);
}
