package com.example.falleterbev2.domain.letter.presentation.dto.response;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class LetterFindSentResponse {
    private final Long letterId;
    private final String receiverName;
    private final String receiverBatch;
    private final LocalDateTime createdAt;

    public LetterFindSentResponse(Long id, String name, String batch, LocalDateTime sentAt) {
        this.letterId = id;
        this.receiverName = name;
        this.receiverBatch = batch;
        this.createdAt = sentAt;
    }
}
