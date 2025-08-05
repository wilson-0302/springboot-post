package com.example.spr_practice.domain;

import com.example.spr_practice.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class User extends AuditingField{
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String phone;

    protected User() {}
    private User(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of(String username, String password, String name, String phone) {
        return new User(username, password, name, phone);
    }

    public UserDto.CreateResDto toCreateResDto() {
        return UserDto.CreateResDto.builder().id(getId()).build();
    }

}
