package com.exmaple.spr_practice.service;

import com.exmaple.spr_practice.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto.CreateResDto create(PostDto.CreateReqDto param);
    void update(PostDto.UpdateReqDto param);
    void delete(PostDto.UpdateReqDto param);
    PostDto.DetailResDto detail(PostDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
}
