package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public enum Post {

    MANAGER("Управляющий"),
    DOCTOR("Врач");

    private final String title;
}
