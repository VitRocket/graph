package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User getByName(String name);

    List<User> findAll();

}
