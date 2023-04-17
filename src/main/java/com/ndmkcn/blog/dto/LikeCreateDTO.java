package com.ndmkcn.blog.dto;

import lombok.Data;

@Data
public class LikeCreateDTO {
    private Long id;
    private Long postId;
    private Long userId;
}
