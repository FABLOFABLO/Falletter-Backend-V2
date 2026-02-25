package com.example.falleterbev2.domain.feed.presentation.dto.response;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.presentation.dto.CommentResponse;
import com.example.falleterbev2.domain.feed.domain.Feed;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FeedDetailResponse {
    private final Long userId;
    private final Long feedId;
    private final String author;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final List<CommentResponse> comments;

    public FeedDetailResponse(Feed feed, List<CommentResponse> comments) {
        this.userId = feed.getUser().getId();
        this.feedId = feed.getId();
        this.author = feed.getUser().getName();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.createdAt = feed.getCreatedAt();
        this.comments = comments;
    }
}
