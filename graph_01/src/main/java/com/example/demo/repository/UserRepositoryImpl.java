package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        user.setId(users.indexOf(user));
        return user;
    }

    @Override
    public User getByName(String name) {
        return users.stream()
                    .filter(user -> name.equals(user.getName()))
                    .findAny()
                    .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
