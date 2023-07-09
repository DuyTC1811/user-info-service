package com.example.userinfomanager.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleMapper {
    String findByRoleName(String request);

}
