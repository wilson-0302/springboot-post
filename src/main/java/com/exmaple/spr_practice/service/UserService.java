package com.exmaple.spr_practice.service;

import com.exmaple.spr_practice.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto.LoginResDto login(UserDto.LoginReqDto param);
    UserDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(UserDto.UpdateReqDto param);
    UserDto.DetailResDto detail(UserDto.DetailReqDto param);
}
