package com.ndmkcn.blog.controller;

import com.ndmkcn.blog.dto.PostCreateDTO;
import com.ndmkcn.blog.dto.PostUpdateDTO;
import com.ndmkcn.blog.entity.Post;
import com.ndmkcn.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> id){
        return this.postService.getAllPosts(id);

    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return this.postService.getPostById(id);
    }

    @PostMapping
    public Post savePost(@RequestBody PostCreateDTO newPostCreateDTO){
        return this.postService.savePost(newPostCreateDTO);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody PostUpdateDTO postUpdateDTO, @PathVariable Long id){
        return this.postService.updatePost(postUpdateDTO,id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        this.postService.deletePost(id);
    }
}
