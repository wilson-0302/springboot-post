package com.example.spr_practice.service;

import com.example.spr_practice.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    /**/
    PostDto.CreateResDto create(PostDto.CreateReqDto param);
    void update(PostDto.UpdateReqDto param);
    void delete(PostDto.UpdateReqDto param);
    PostDto.DetailResDto detail(PostDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
}