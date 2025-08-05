package com.example.spr_practice.service;

import com.example.spr_practice.dto.UserDto;

public interface UserService {
    UserDto.LoginResDto login(UserDto.LoginReqDto param);
    UserDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(UserDto.UpdateReqDto param);
    UserDto.DetailResDto detail(UserDto.DetailReqDto param);
}
