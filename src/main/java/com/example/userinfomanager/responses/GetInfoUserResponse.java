package com.example.userinfomanager.responses;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GetInfoUserResponse {
    private String userId;
    private String username;
    private String userCode;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
    private Timestamp registeredAt;
}
