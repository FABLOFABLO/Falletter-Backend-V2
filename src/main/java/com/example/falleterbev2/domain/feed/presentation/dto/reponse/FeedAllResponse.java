package com.example.falleterbev2.domain.feed.presentation.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedAllResponse {
    private Long userId;

    private Long feedId;

    private String author;

    private String title;

    private String content;

    private LocalDateTime createdAt;
}
