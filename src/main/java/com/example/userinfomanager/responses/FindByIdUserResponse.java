package com.example.userinfomanager.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FindByIdUserResponse {
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
}

