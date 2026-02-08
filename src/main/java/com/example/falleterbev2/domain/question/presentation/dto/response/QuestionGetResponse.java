package com.example.falleterbev2.domain.question.presentation.dto.response;

import lombok.Getter;

@Getter
public class QuestionGetResponse {
    private Long id;

    public QuestionGetResponse(Long id) {
        this.id = id;
    }
}
