package com.example.spr_practice.domain;

import com.example.spr_practice.dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class Post extends AuditingField{
    Long userId;
    @Column(nullable = false) String title;
    @Column(length = 4000) String content;
    private String img;

    protected Post() {}
    private Post(Long userId, String title, String content, String img) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public static Post of(Long userId, String title, String content, String img) {
        return new Post(userId, title, content, img);
    }

    public PostDto.CreateResDto toCreateResDto() {
        return PostDto.CreateResDto.builder().id(getId()).build();
    }
}
