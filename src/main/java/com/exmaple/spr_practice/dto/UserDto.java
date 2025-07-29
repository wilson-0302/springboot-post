package com.exmaple.spr_practice.dto;

import com.exmaple.spr_practice.domain.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class UserDto {
    @Setter @Getter @Builder
    public static class LoginReqDto {
        String username;
        String password;
    }
    @Setter @Getter @Builder
    public static class LoginResDto {
        Long id;
    }

    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long id;

        String username;
        String password;
        String name;
        String phone;

        public User toEntity(){
            return User.of(getUsername(), getPassword(), getName(), getPhone());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id;
        Boolean deleted;

        String username;
        String password;
        String name;
        String phone;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id; //필수!!
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String username;
        String password;
        String name;
        String phone;

        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }
}
