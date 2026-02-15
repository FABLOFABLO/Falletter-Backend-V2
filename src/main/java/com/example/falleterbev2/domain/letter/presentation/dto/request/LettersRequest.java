package com.example.falleterbev2.domain.letter.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LettersRequest {

    @NotBlank(message = "receiverId는 필수입니다.")
    private Long receiverId;

    @NotBlank(message = "content는 필수입니다.")
    private String content;
}
