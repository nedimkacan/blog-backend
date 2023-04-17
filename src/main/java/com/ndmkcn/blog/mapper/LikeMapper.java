package com.ndmkcn.blog.mapper;

import com.ndmkcn.blog.dto.LikeCreateDTO;
import com.ndmkcn.blog.entity.Like;
import com.ndmkcn.blog.entity.Post;
import com.ndmkcn.blog.entity.User;

public class LikeMapper {
    public static Like toEntity(LikeCreateDTO likeCreateDTO, Post post, User user){
        Like like=new Like();
        like.setId(likeCreateDTO.getId());
        like.setPost(post);
        like.setUser(user);
        return like;
    }
}
