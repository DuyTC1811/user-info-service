package com.example.userinfomanager.requests;

import com.example.userinfomanager.responses.GetInfoUserResponse;
import io.cqrs.query.IQuery;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetInfoUserRequest implements IQuery<GetInfoUserResponse> {
    private String userId;
}
