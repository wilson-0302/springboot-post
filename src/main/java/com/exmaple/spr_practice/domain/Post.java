package com.exmaple.spr_practice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class Post {
    Long userId;
    @Column(nullable = false) String title;
    @Column(length = 4000) String content;

    protected Post() {}
    private Post(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static Post of(Long userId, String title, String content) {
        return new Post(userId, title, content);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
