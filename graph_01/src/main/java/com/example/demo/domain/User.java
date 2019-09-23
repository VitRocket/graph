package com.example.demo.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name", "post"})
public class User {

    private Integer id;
    private final String name;
    private Set<User> friends = new HashSet<>();
    private Post post;

    public void addFriend(User user) {
        friends.add(user);
    }
}
