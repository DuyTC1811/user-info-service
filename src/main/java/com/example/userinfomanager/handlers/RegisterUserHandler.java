package com.example.userinfomanager.handlers;

import com.example.userinfomanager.mappers.IUserMapper;
import com.example.userinfomanager.requests.RegisterUserRequest;
import com.example.userinfomanager.responses.RegisterUserResponse;
import io.cqrs.command.ICommandHandler;
import io.cqrs.model.BaseResponse;
import io.exceptions.models.BaseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.example.userinfomanager.constants.RegexConstants.EMAIL_REGEX;
import static com.example.userinfomanager.constants.RegexConstants.PHONE_NUMBER_REGEX;
import static io.utilities.constant.ERole.*;
import static io.utilities.regexs.RegexUtils.validateRegex;

@Service
public class RegisterUserHandler implements ICommandHandler<RegisterUserResponse, RegisterUserRequest> {
    private final IUserMapper userMapper;

    public RegisterUserHandler(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public BaseResponse<RegisterUserResponse> handler(RegisterUserRequest request) {
        if (userMapper.checkUserExists(request.getUsername())) {
            throw new BaseException("Username is already taken!");
        }
        if (!validateRegex(request.getEmail(), EMAIL_REGEX)) {
            throw new BaseException(request.getEmail() + " Invalid Email! ");
        }
        if (userMapper.checkEmailExists(request.getEmail())) {
            throw new BaseException("Email is already in use!");
        }
        if (!validateRegex(request.getMobile(), PHONE_NUMBER_REGEX)) {
            throw new BaseException(request.getMobile() + " Invalid Phone Number! ");
        }
        if (userMapper.checkMobileExists(request.getMobile())) {
            throw new BaseException("Phone is already in use!");
        }

        Set<String> strRoles = request.getRoles();
        Set<String> roles = new HashSet<>();
        if (strRoles == null) {
            String userRoleId = userMapper.findByRoleName(ROLE_USER.name());
            roles.add(userRoleId);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        String admin = userMapper.findByRoleName(ROLE_ADMIN.getName());
                        roles.add(admin);
                        break;
                    case "MANAGER":
                        String manager = userMapper.findByRoleName(ROLE_MANAGER.getName());
                        roles.add(manager);
                        break;
                    case "USER":
                        String userRoleId = userMapper.findByRoleName(ROLE_USER.getName());
                        roles.add(userRoleId);
                        break;
                    default:
                        new RegisterUserResponse(role + " Role does not exist !");
                }
            });
        }
        request.setRoles(roles);
        request.setPassword(request.getPassword());
        int user = userMapper.createUser(request);
        if (user == 0) {
            throw new BaseException("Registration failed !");
        }
        RegisterUserResponse response = RegisterUserResponse.builder()
                .messenger("User registered successfully! " + request.getUsername()).build();
        return new BaseResponse<>(response);
    }
}
