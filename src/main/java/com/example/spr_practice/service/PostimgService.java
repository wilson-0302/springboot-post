package com.example.spr_practice.service;

import com.example.spr_practice.dto.PostimgDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostimgService {
    /**/
    PostimgDto.CreateResDto create(PostimgDto.CreateReqDto param);
    void update(PostimgDto.UpdateReqDto param);
    void delete(PostimgDto.UpdateReqDto param);
    PostimgDto.DetailResDto detail(PostimgDto.DetailReqDto param);
}
