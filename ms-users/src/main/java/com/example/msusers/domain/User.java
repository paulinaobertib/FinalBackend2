package com.example.msusers.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {
    private String id;

    private String userName;

    private String email;

    private String firstName;

    protected List<Bill> bills;
}
