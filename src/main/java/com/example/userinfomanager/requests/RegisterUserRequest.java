package com.example.userinfomanager.requests;

import com.example.userinfomanager.responses.RegisterUserResponse;
import io.cqrs.command.ICommand;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RegisterUserRequest implements ICommand<RegisterUserResponse> {
    @Hidden
    private String userId = UUID.randomUUID().toString();
    private String username;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
    private Set<String> roles;
}
