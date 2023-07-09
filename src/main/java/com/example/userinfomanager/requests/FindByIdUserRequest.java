package com.example.userinfomanager.requests;

import com.example.userinfomanager.responses.FindByIdUserResponse;
import io.cqrs.query.IPage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FindByIdUserRequest implements IPage<FindByIdUserResponse> {
    private int limit;
    private int offset;
}
