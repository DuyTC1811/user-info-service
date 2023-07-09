package com.example.userinfomanager.handlers;

import com.example.userinfomanager.mappers.IUserMapper;
import com.example.userinfomanager.requests.GetInfoUserRequest;
import com.example.userinfomanager.responses.GetInfoUserResponse;
import io.cqrs.model.BaseResponse;
import io.cqrs.query.IQueryHandler;
import org.springframework.stereotype.Service;

@Service
public class GetInfoUserHandler implements IQueryHandler<GetInfoUserResponse, GetInfoUserRequest> {
    private final IUserMapper userMapper;

    public GetInfoUserHandler(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public BaseResponse<GetInfoUserResponse> handler(GetInfoUserRequest getInfoUserRequest) {
        GetInfoUserResponse userById = userMapper.getUserById(getInfoUserRequest);
        return new BaseResponse<>(userById);
    }
}
