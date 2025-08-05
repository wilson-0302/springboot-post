package com.example.spr_practice.service.impl;

import com.example.spr_practice.domain.User;
import com.example.spr_practice.dto.UserDto;
import com.example.spr_practice.repository.UserRepository;
import com.example.spr_practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Override
    public UserDto.LoginResDto login(UserDto.LoginReqDto param) {
        Long id = null;
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(user != null){
            id = user.getId();
        }
        return UserDto.LoginResDto.builder().id(id).build();
    }

    @Override
    public UserDto.CreateResDto create(UserDto.CreateReqDto param) {
        User user = userRepository.save(param.toEntity());

        return user.toCreateResDto();
    }
    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ user.setDeleted(param.getDeleted()); }
        if(param.getUsername() != null){ user.setUsername(param.getUsername()); }
        if(param.getPassword() != null){ user.setPassword(param.getPassword()); }
        if(param.getName() != null){ user.setName(param.getName()); }
        if(param.getPhone() != null){ user.setPhone(param.getPhone()); }
        userRepository.save(user);
    }
    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(UserDto.DetailReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return UserDto.DetailResDto.builder()
                .id(user.getId())
                .deleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public UserDto.DetailResDto detail(UserDto.DetailReqDto param) {
        return get(param);
    }
}
