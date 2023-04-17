package com.ndmkcn.blog.dto;

import lombok.Data;

@Data
public class LikeCreateDTO {
    private Long id;
    private Long userId;
    private Long postId;
}
