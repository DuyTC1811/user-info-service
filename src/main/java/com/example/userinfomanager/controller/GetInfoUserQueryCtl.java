package com.example.userinfomanager.controller;

import com.example.userinfomanager.requests.GetInfoUserRequest;
import com.example.userinfomanager.responses.GetInfoUserResponse;
import io.cqrs.controller.QueryController;
import io.cqrs.model.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetInfoUserQueryCtl extends QueryController<GetInfoUserResponse, GetInfoUserRequest> {

    @GetMapping("/user-id/{id}")
    public ResponseEntity<BaseResponse<GetInfoUserResponse>> getInfoUser(@PathVariable String id) {
        GetInfoUserRequest request = GetInfoUserRequest.builder().userId(id).build();
        return execute(request);
    }
}
