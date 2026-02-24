package com.example.falleterbev2.domain.feed.presentation.dto.response;

import com.example.falleterbev2.domain.feed.domain.Feed;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class FeedAllResponse {
    private Long userId;
    private Long feedId;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public FeedAllResponse(Feed feed) {
        this.userId = feed.getUser().getId();
        this.feedId = feed.getId();
        this.author = feed.getUser().getName();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.createdAt = feed.getCreatedAt();
    }
}
