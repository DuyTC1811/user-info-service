package com.example.userinfomanager.controller;

import com.example.userinfomanager.requests.FindByIdUserRequest;
import com.example.userinfomanager.responses.FindByIdUserResponse;
import io.cqrs.controller.PageController;
import io.cqrs.model.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FindByIdUserQueryCtrl extends PageController<FindByIdUserResponse, FindByIdUserRequest> {

    @GetMapping("/find-all/{limit}/{offset}")
    protected ResponseEntity<PageResponse<FindByIdUserResponse>> executePage(@PathVariable int limit , @PathVariable int offset) {
        FindByIdUserRequest request = FindByIdUserRequest.builder().limit(limit).offset(offset).build();
        return execute(request);
    }

}
