package com.example.userinfomanager.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetInfoUserResponse {
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
}
