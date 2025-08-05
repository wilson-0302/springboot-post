package com.example.spr_practice.service.impl;

import com.example.spr_practice.domain.Post;
import com.example.spr_practice.domain.Postimg;
import com.example.spr_practice.dto.PostDto;
import com.example.spr_practice.dto.PostimgDto;
import com.example.spr_practice.repository.PostimgRepository;
import com.example.spr_practice.service.PostimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostimgServiceImpl implements PostimgService {

    final PostimgRepository postimgRepository;

    /**/

    @Override
    public PostimgDto.CreateResDto create(PostimgDto.CreateReqDto param) {
        return postimgRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(PostimgDto.UpdateReqDto param) {
        Postimg postimg = postimgRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ postimg.setDeleted(param.getDeleted()); }
        if(param.getImg() != null){ postimg.setImg(param.getImg()); }
        postimgRepository.save(postimg);
    }

    @Override
    public void delete(PostimgDto.UpdateReqDto param) {
        update(PostimgDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostimgDto.DetailResDto get(PostimgDto.DetailReqDto param) {
        Postimg postimg = postimgRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return PostimgDto.DetailResDto.builder()
                .id(postimg.getId())
                .deleted(postimg.getDeleted())
                .createdAt(postimg.getCreatedAt())
                .modifiedAt(postimg.getModifiedAt())
                .postId(postimg.getPostId())
                .img(postimg.getImg())
                .build();
    }
    @Override
    public PostimgDto.DetailResDto detail(PostimgDto.DetailReqDto param) {
        return get(param);
    }
}
