package com.ndmkcn.blog.controller;

import com.ndmkcn.blog.dto.LikeCreateDTO;
import com.ndmkcn.blog.entity.Like;
import com.ndmkcn.blog.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {
    private final LikeService likeService;
    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return this.likeService.getAllLikes(userId,postId);
    }
    @GetMapping("/{id}")
    public Like getLikeById(@PathVariable Long id){
        return this.likeService.getLikeById(id);
    }
    @PostMapping
    public Like saveLike(@RequestBody LikeCreateDTO likeCreateDTO){
        return this.likeService.saveLike(likeCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id){
        this.likeService.deleteLike(id);
    }
}
