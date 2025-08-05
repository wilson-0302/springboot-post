package com.example.spr_practice.domain;

import com.example.spr_practice.dto.PostimgDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Postimg extends AuditingField{
    Long postId;
    String img;

    protected Postimg() {}
    private Postimg(Long postId, String img) {
        this.postId = postId;
        this.img = img;
    }

    public static Postimg of(Long postId, String img) {
        return new Postimg(postId, img);
    }

    public PostimgDto.CreateResDto toCreateResDto() {
        return PostimgDto.CreateResDto.builder().id(getId()).build();
    }
}
