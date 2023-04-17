package com.ndmkcn.blog.mapper;

import com.ndmkcn.blog.dto.CommentCreateDTO;
import com.ndmkcn.blog.dto.CommentUpdateDTO;
import com.ndmkcn.blog.entity.Comment;
import com.ndmkcn.blog.entity.Post;
import com.ndmkcn.blog.entity.User;

public class CommentMapper {
    public static Comment toEntity(CommentCreateDTO commentCreateDTO, User user, Post post){
        Comment comment=new Comment();
        comment.setId(commentCreateDTO.getId());
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(commentCreateDTO.getText());
        return comment;
    }

    public static Comment toUpdateEntity(CommentUpdateDTO commentUpdateDTO, Comment comment){
        comment.setText(commentUpdateDTO.getText());
        return comment;
    }
}
