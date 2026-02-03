package com.example.falleterbev2.domain.letter.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LettersSendRequest {
    @NotBlank
    private String userName;

    @NotBlank(message = "content는 필수입니다.")
    private String content;
}
