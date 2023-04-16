package com.ndmkcn.blog.controller;

import com.ndmkcn.blog.dto.CommentCreateDTO;
import com.ndmkcn.blog.dto.CommentUpdateDTO;
import com.ndmkcn.blog.entity.Comment;
import com.ndmkcn.blog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
        return this.commentService.getAllComments(postId,userId);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id){
        return this.commentService.getCommentById(id);
    }

    @PostMapping
    public Comment saveComment(@RequestBody CommentCreateDTO commentCreateDTO){
        return this.commentService.saveComment(commentCreateDTO);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@RequestBody CommentUpdateDTO commentUpdateDTO, @PathVariable Long id){
        return this.commentService.updateComment(commentUpdateDTO,id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        this.commentService.deleteComment(id);
    }
}
