package com.ndmkcn.blog.repository;

import com.ndmkcn.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUserIdAndPostId(Long postId, Long userId);

    List<Comment> findByPostId(Long postId);

    List<Comment> findByUserId(Long userId);
}
