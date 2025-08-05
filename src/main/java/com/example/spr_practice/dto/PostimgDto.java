package com.example.spr_practice.dto;

import com.example.spr_practice.domain.Postimg;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class PostimgDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long postId;
        String img;

        public Postimg toEntity(){
            return Postimg.of(getPostId(), getImg());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id; //필수!!
        Boolean deleted;

        String img;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id; //필수!!
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;

        Long postId;
        String img;
    }
}
