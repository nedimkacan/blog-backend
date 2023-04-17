package com.ndmkcn.blog.service;

import com.ndmkcn.blog.dto.PostCreateDTO;
import com.ndmkcn.blog.dto.PostUpdateDTO;
import com.ndmkcn.blog.entity.Post;
import com.ndmkcn.blog.entity.User;
import com.ndmkcn.blog.mapper.PostMapper;
import com.ndmkcn.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    public List<Post> getAllPosts(Optional<Long> id){
        if (id.isPresent()) {
            return postRepository.findByUserId(id.get());
        }
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post savePost(PostCreateDTO postCreateDTO) {
        User user = userService.getUserById(postCreateDTO.getUserId());
        if (user == null) {
            return null;
        }
        Post post = PostMapper.toEntity(postCreateDTO, user);
        return this.postRepository.save(post);
    }

    public Post updatePost(PostUpdateDTO postUpdateDTO, Long id) {
        Optional<Post> post=this.postRepository.findById(id);
        if (post.isPresent()){
            Post convertPost=PostMapper.toUpdateEntity(postUpdateDTO,post.get());
            return this.postRepository.save(convertPost);
        }
        return null;
    }

    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }
}
