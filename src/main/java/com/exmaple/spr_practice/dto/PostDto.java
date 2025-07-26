package com.exmaple.spr_practice.dto;

import com.exmaple.spr_practice.domain.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long id;
        String title;
        String content;

        public Post toEntity(){
            return Post.of(getUserId(), getTitle(), getContent());
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
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id; //필수!!
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long userId;
        String title;
        String content;

        String userUsername;
        String userName;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto {
        Long userId;
        String title;
        Boolean deleted;
    }


    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id; //필수!!
        Boolean deleted;
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
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto {
        Boolean deleted;
    }
}
