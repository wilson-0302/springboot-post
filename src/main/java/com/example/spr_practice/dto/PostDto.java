package com.example.spr_practice.dto;

import com.example.spr_practice.domain.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long userId;
        String title;
        String content;
        String img;

        List<String> imgs;

        public Post toEntity(){
            return Post.of(getUserId(), getTitle(), getContent(), getImg());
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

        String title;
        String content;
        String img;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id; //필수!!
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String title;
        String content;
        String img;

        List<PostimgDto.DetailResDto> imgs;

        String userUsername;
        String userName;


        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto {
        Long userId;
        Long id;
        String title;
        String content;
        Boolean deleted;
    }
}
