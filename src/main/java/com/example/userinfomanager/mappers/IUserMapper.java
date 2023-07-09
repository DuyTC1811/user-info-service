package com.example.userinfomanager.mappers;

import com.example.userinfomanager.requests.FindByIdUserRequest;
import com.example.userinfomanager.requests.GetInfoUserRequest;
import com.example.userinfomanager.requests.RegisterUserRequest;
import com.example.userinfomanager.responses.FindByIdUserResponse;
import com.example.userinfomanager.responses.GetInfoUserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    int totalItems();

    int createUser(RegisterUserRequest request);

    GetInfoUserResponse getUserById(GetInfoUserRequest request);

    List<FindByIdUserResponse> findById(FindByIdUserRequest request);

    String findByRoleName(String request);

    boolean checkUserExists(String username);

    boolean checkEmailExists(String email);

    boolean checkMobileExists(String mobile);
}
