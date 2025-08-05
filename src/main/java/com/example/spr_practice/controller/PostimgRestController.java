package com.example.spr_practice.controller;

import com.example.spr_practice.dto.PostimgDto;
import com.example.spr_practice.service.PostimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/postimg")
@RestController
public class PostimgRestController {

    final PostimgService postimgService;

    /**/

    @PostMapping("")
    public ResponseEntity<PostimgDto.CreateResDto> create(@RequestBody PostimgDto.CreateReqDto param){
        return ResponseEntity.ok(postimgService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostimgDto.UpdateReqDto param){
        postimgService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostimgDto.UpdateReqDto param){
        postimgService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("")
    public ResponseEntity<PostimgDto.DetailResDto> detail(PostimgDto.DetailReqDto param){
        return ResponseEntity.ok(postimgService.detail(param));
    }
}
