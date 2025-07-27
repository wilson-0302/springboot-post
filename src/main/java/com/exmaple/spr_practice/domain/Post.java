package com.exmaple.spr_practice.domain;

import com.exmaple.spr_practice.dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class Post extends AuditingField{
    @Column(nullable = false) String title;
    @Column(length = 4000) String content;

    protected Post() {}
    private Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Post of(String title, String content) {
        return new Post(title, content);
    }

    public PostDto.CreateResDto toCreateResDto() {
        return PostDto.CreateResDto.builder().id(getId()).build();
    }
}
