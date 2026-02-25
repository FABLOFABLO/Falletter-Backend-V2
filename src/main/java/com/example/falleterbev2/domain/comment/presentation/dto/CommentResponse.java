package com.example.falleterbev2.domain.comment.presentation.dto;

import com.example.falleterbev2.domain.comment.domain.Comment;
import lombok.*;
import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private final Long id;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.author = comment.getUser().getName();
        this.createdAt = comment.getCreatedAt();
    }
}
