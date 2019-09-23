package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.domain.UserWay;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public void makeFriend(User user1, User user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * breadth-first search
     * Поиск в ширину
     */
    @Override
    public User findPostByFriends(User user, Post post) {
        Queue<User> queue = new LinkedList<>();
        Set<User> checked = new HashSet<>();
        queue.addAll(user.getFriends());
        while (!queue.isEmpty()) {
            User u = queue.element();
            queue.remove();
            checked.add(u);
            if (post.equals(u.getPost())) {
                return u;
            } else {
                u.getFriends().forEach(user1 -> {
                    if (!checked.contains(user1)) {
                        queue.add(user1);
                    }
                });
            }
        }
        return null;
    }

    /**
     * breadth-first search with way
     * Поиск в ширину с путём
     */
    @Override
    public UserWay findPostByFriendsWay(User user, Post post) {
        UserWay father = getUserWay(user);

        Queue<UserWay> queue = new LinkedList<>();
        Set<UserWay> checked = new HashSet<>();

        Set<UserWay> friends = father.getFriends().stream()
                                     .map(this::getUserWay)
                                     .collect(Collectors.toSet());

        friends.forEach(u -> u.setFather(father));

        queue.addAll(friends);

        while (!queue.isEmpty()) {
            UserWay u = queue.element();
            queue.remove();
            checked.add(u);
            if (post.equals(u.getPost())) {
                return u;
            } else {

                Set<UserWay> uFriends = u.getFriends().stream()
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

    private UserWay getUserWay(User user) {
        UserWay father = new UserWay(user.getName());
        BeanUtils.copyProperties(user, father);
        return father;
    }
}
