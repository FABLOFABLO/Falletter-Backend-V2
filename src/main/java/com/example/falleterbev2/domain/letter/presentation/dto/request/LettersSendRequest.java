package com.example.falleterbev2.domain.letter.presentation.dto.request;

import com.example.falleterbev2.domain.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LettersSendRequest {
    @NotBlank
    private User userName;

    @NotBlank(message = "content는 필수입니다.")
    private String content;
}
