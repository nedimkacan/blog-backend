package com.ndmkcn.blog.service;

import com.ndmkcn.blog.dto.LikeCreateDTO;
import com.ndmkcn.blog.entity.Like;
import com.ndmkcn.blog.entity.Post;
import com.ndmkcn.blog.entity.User;
import com.ndmkcn.blog.mapper.LikeMapper;
import com.ndmkcn.blog.repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        } else if(userId.isPresent()){
            return likeRepository.findByUserId(userId.get());
        } else if(postId.isPresent()){
            return likeRepository.findByPostId(postId.get());
        } else {
            return likeRepository.findAll();
        }
    }

    public Like getLikeById(Long id) {
        return likeRepository.findById(id).orElse(null);
    }

    public Like saveLike(LikeCreateDTO likeCreateDTO) {
        Post post=postService.getPostById(likeCreateDTO.getId());
        User user=userService.getUserById(likeCreateDTO.getId());
        if (user != null && post != null) {
            Like like= LikeMapper.toEntity(likeCreateDTO,post,user);
            return likeRepository.save(like);
        }
        return null;
    }

    public void deleteLike(Long id) {
        this.likeRepository.deleteById(id);
    }
}
