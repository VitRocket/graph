package com.example.demo.service;

import com.example.demo.domain.Cell;
import com.example.demo.domain.CellWay;

public interface CellService {
    Cell create(Cell cell);

    void makeLink(Cell cell1, Cell cell2);

    Cell getByCoordinates(int x, int y);

    CellWay findPostByFriendsWay(Cell cell, Cell cellEnd);
}