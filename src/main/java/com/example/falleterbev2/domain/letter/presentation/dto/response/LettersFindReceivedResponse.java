package com.example.falleterbev2.domain.letter.presentation.dto.response;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class LettersFindReceivedResponse {
    private final Long letterId;
    private final String preview;
    private final LocalDateTime receivedAt;

    public LettersFindReceivedResponse(Long id, String content, LocalDateTime createdAt) {
        this.letterId = id;
        this.preview = content;
        this.receivedAt = createdAt;
    }
}
