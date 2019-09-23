package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserWay extends User {

    private UserWay father;

    public UserWay(String name) {
        super(name);
    }
}
