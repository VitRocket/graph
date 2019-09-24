package com.example.demo.datainit;

import com.example.demo.domain.Cell;
import com.example.demo.service.CellService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataInitImpl implements DataInit {

    private final CellService cellService;

    @Override
    public void dataInit() {

        List<List<Cell>> rows = new ArrayList<>();

        for (int x = 0; x < 5; x++) {
            List<Cell> xs = new ArrayList<>();
            for (int y = 0; y < 5; y++) {
                xs.add(new Cell(x, y));
            }
            rows.add(xs);
        }

        cellService.makeLink(rows.get(0).get(0), rows.get(0).get(1));
        cellService.makeLink(rows.get(1).get(0), rows.get(2).get(0));
        cellService.makeLink(rows.get(1).get(0), rows.get(1).get(1));
        cellService.makeLink(rows.get(2).get(0), rows.get(3).get(0));
        cellService.makeLink(rows.get(3).get(0), rows.get(4).get(0));
        cellService.makeLink(rows.get(4).get(0), rows.get(4).get(1));
        cellService.makeLink(rows.get(0).get(1), rows.get(0).get(2));
        cellService.makeLink(rows.get(1).get(1), rows.get(1).get(2));
        cellService.makeLink(rows.get(1).get(1), rows.get(2).get(1));
        cellService.makeLink(rows.get(2).get(1), rows.get(3).get(1));
        cellService.makeLink(rows.get(3).get(1), rows.get(3).get(2));
        cellService.makeLink(rows.get(0).get(2), rows.get(1).get(2));
        cellService.makeLink(rows.get(1).get(2), rows.get(2).get(2));
        cellService.makeLink(rows.get(2).get(2), rows.get(2).get(3));
        cellService.makeLink(rows.get(3).get(2), rows.get(3).get(3));
        cellService.makeLink(rows.get(4).get(2), rows.get(4).get(3));
        cellService.makeLink(rows.get(0).get(3), rows.get(1).get(3));
        cellService.makeLink(rows.get(0).get(3), rows.get(0).get(4));
        cellService.makeLink(rows.get(1).get(3), rows.get(2).get(3));
        cellService.makeLink(rows.get(3).get(3), rows.get(3).get(4));
        cellService.makeLink(rows.get(4).get(3), rows.get(4).get(4));
        cellService.makeLink(rows.get(0).get(4), rows.get(1).get(4));
        cellService.makeLink(rows.get(1).get(4), rows.get(2).get(4));
        cellService.makeLink(rows.get(2).get(4), rows.get(3).get(4));
        cellService.makeLink(rows.get(3).get(4), rows.get(4).get(4));

        rows.forEach(c -> c.forEach(cellService::create));

        log.info("");
        log.info("----- REPOSITORY IS COMPLETED -----");
        log.info("Rows:");
        rows.forEach(с -> log.info(с.toString()));
        log.info("===== ======================= =====");
    }
}
