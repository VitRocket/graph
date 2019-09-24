package com.example.demo.repository;

import com.example.demo.domain.Cell;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CellRepositoryImpl implements CellRepository {

    private List<Cell> cells = new ArrayList<>();

    @Override
    public Cell save(Cell cell) {
        cells.add(cell);
        cell.setId(cells.indexOf(cell));
        return cell;
    }

    @Override
    public List<Cell> findAll() {
        return cells;
    }

    @Override
    public Cell findByCoordinates(int x, int y) {
        return cells.stream()
                .filter(cell -> cell.getX().equals(x) && cell.getY().equals(y))
                .findAny()
                .orElse(null);
    }
}