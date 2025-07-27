package com.exmaple.spr_practice.service.impl;

import com.exmaple.spr_practice.domain.Post;
import com.exmaple.spr_practice.dto.PostDto;
import com.exmaple.spr_practice.repository.PostRepository;
import com.exmaple.spr_practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;

    @Override
    public PostDto.CreateResDto create(PostDto.CreateReqDto param) {
        Post post = postRepository.save(param.toEntity());

        return post.toCreateResDto();
    }
    @Override
    public void update(PostDto.UpdateReqDto param) {
        Post post = postRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ post.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ post.setTitle(param.getTitle()); }
        if(param.getContent() != null){ post.setContent(param.getContent()); }
        postRepository.save(post);
    }
    @Override
    public void delete(PostDto.UpdateReqDto param) {
        update(PostDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostDto.DetailResDto get(PostDto.DetailReqDto param) {
        Post post = postRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return PostDto.DetailResDto.builder()
                .id(post.getId())
                .deleted(post.getDeleted())
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    @Override
    public PostDto.DetailResDto detail(PostDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<PostDto.DetailResDto> list(PostDto.ListReqDto param) {
        List<PostDto.DetailResDto> resultList = new ArrayList<>();
        List<Post> list = postRepository.findAll();
        for(Post each : list){
            boolean isSerached = true;
            if(param.getDeleted() != null){
                System.out.println("param.getDeleted() not null?");
                if(each.getDeleted() != param.getDeleted()){
                    isSerached = false;
                    System.out.println("param.getDeleted() false");
                }
            }
            if(param.getTitle() != null && !param.getTitle().isEmpty()){
                System.out.println("param.getName() not null?");
                if(!each.getTitle().contains(param.getTitle())){
                    isSerached = false;
                    System.out.println("param.getName() : " + isSerached);
                }
            }
            if(param.getContent() != null && !param.getContent().isEmpty()){
                System.out.println("param.getPhone() not null?");
                if(!each.getContent().contains(param.getContent())){
                    isSerached = false;
                    System.out.println("param.getPhone() : " + isSerached);
                }
            }
            if(isSerached){
                resultList.add(get(PostDto.DetailReqDto.builder().id(each.getId()).build()));
            }
        }
        return resultList;
    }
}
