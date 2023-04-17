package com.ndmkcn.blog.dto;

import lombok.Data;

@Data
public class PostCreateDTO {
    private Long id;
    private Long userId;
    private String title;
    private String text;
}
