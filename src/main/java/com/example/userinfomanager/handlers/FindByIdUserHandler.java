package com.example.userinfomanager.handlers;

import com.example.userinfomanager.mappers.IUserMapper;
import com.example.userinfomanager.requests.FindByIdUserRequest;
import com.example.userinfomanager.responses.FindByIdUserResponse;
import io.cqrs.model.PageResponse;
import io.cqrs.query.IPageHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindByIdUserHandler implements IPageHandler<FindByIdUserResponse, FindByIdUserRequest> {
    private final IUserMapper userMapper;

    public FindByIdUserHandler(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public PageResponse<FindByIdUserResponse> handle(FindByIdUserRequest request) {
        List<FindByIdUserResponse> byIdList = userMapper.findById(request);
        int totalItems = userMapper.totalItems();
        return new PageResponse<>(byIdList, request.getLimit(), request.getOffset(), totalItems);
    }
}
