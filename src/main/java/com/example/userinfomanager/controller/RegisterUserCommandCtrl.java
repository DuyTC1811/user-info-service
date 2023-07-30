package com.example.userinfomanager.controller;

import com.example.userinfomanager.requests.RegisterUserRequest;
import com.example.userinfomanager.responses.RegisterUserResponse;
import io.cqrs.controller.CommandController;
import io.cqrs.model.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class RegisterUserCommandCtrl extends CommandController<RegisterUserResponse, RegisterUserRequest> {

    @PostMapping("/register-user")
    protected ResponseEntity<BaseResponse<RegisterUserResponse>> registerUser(@RequestBody RegisterUserRequest request) {
        return execute(request);
    }
}
