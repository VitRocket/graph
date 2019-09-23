package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.domain.UserWay;

import java.util.List;

public interface UserService {

    User create(User user);

    User getByName(String name);

    void makeFriend(User user1, User user2);

    List<User> findAll();

    User findPostByFriends(User user, Post post);

    UserWay findPostByFriendsWay(User user, Post post);
}
