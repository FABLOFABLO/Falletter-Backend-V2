package com.example.falleterbev2.domain.letter.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LettersFindReceivedResponse {
    private Long letterId;
    private String senderName;
    private String content;
    private LocalDateTime sendAt;
}
