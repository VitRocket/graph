package com.example.demo.service;

import com.example.demo.domain.Cell;
import com.example.demo.domain.CellWay;
import com.example.demo.repository.CellRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CellServiceImpl implements CellService {

    private final CellRepository cellRepository;

    @Override
    public Cell create(Cell cell) {
        return cellRepository.save(cell);
    }

    @Override
    public void makeLink(Cell cell1, Cell cell2) {
        cell1.addLink(cell2);
        cell2.addLink(cell1);
    }

    @Override
    public Cell getByCoordinates(int x, int y) {
        return cellRepository.findByCoordinates(x, y);
    }

    @Override
    public CellWay findPostByFriendsWay(Cell cell, Cell cellEnd) {
        CellWay father = getUserWay(cell);

        Set<CellWay> checked = new HashSet<>();

        Set<CellWay> friends = father.getLinks().stream()
                                     .map(this::getUserWay)
                                     .collect(Collectors.toSet());

        friends.forEach(u -> u.setFather(father));

        Queue<CellWay> queue = new LinkedList<>(friends);

        while (!queue.isEmpty()) {
            CellWay u = queue.element();
            queue.remove();
            checked.add(u);
            if (cellEnd.getX().equals(u.getX()) && cellEnd.getY().equals(u.getY())) {
                return u;
            } else {
                Set<CellWay> uFriends = u.getLinks().stream()
                                         .map(this::getUserWay)
                                         .collect(Collectors.toSet());
                uFriends.forEach(userWay -> userWay.setFather(u));

                uFriends.forEach(user1 -> {
                    if (!checked.contains(user1)) {
                        queue.add(user1);
                    }
                });
            }
        }
        log.warn("Not find!");
        return null;
    }

    private CellWay getUserWay(Cell cell) {
        CellWay father = new CellWay(cell.getX(), cell.getY());
        BeanUtils.copyProperties(cell, father);
        return father;
    }
}
