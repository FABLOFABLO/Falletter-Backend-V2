package com.example.falleterbev2.domain.letter.presentation.dto.response;

import com.example.falleterbev2.domain.letter.domain.Letter;
import lombok.Getter;

@Getter
public class LetterReadSentResponse {
    private final Long letterId;
    private final String receiverName;
    private final String content;

    public LetterReadSentResponse(Letter letter) {
        this.letterId = letter.getId();
        this.receiverName = letter.getReceiver().getName();
        this.content = letter.getContent();
    }
}
