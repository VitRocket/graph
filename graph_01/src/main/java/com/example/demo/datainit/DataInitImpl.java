package com.example.demo.datainit;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataInitImpl implements DataInit {

    private final UserService userService;

    @Override
    public void dataInit() {

        User vitalii = userService.create(new User("Vitalii"));

        User bob = userService.create(new User("Bob"));
        User klar = userService.create(new User("Klar"));
        User alice = userService.create(new User("Alice"));
        User peg = userService.create(new User("Peg"));
        User audg = userService.create(new User("Audg"));
        User tom = userService.create(new User("Tom"));
        User djon = userService.create(new User("Djon"));

        userService.makeFriend(klar, tom);
        userService.makeFriend(klar, djon);
        userService.makeFriend(vitalii, klar);
        userService.makeFriend(vitalii, alice);
        userService.makeFriend(vitalii, bob);
        userService.makeFriend(alice, peg);
        userService.makeFriend(bob, audg);
        userService.makeFriend(bob, peg);

        peg.setPost(Post.MANAGER);


        List<User> all = userService.findAll();

        log.info("");
        log.info("----- REPOSITORY IS COMPLETED -----");
        all.forEach(user -> log.info(user.toString()));
        log.info("===== ======================= =====");
    }
}
