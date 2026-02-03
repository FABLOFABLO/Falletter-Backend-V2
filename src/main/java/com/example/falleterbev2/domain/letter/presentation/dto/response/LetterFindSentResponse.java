package com.example.falleterbev2.domain.letter.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LetterFindSentResponse {
    private Long letterId;
    private String receiverName;
    private String receiverBatch;
    private String sentAt;
}
