package com.example.falleterbev2.domain.question.presentation;

import com.example.falleterbev2.domain.question.presentation.dto.response.QuestionGetResponse;
import com.example.falleterbev2.domain.question.service.QuestionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionGetService questionGetService;

    @GetMapping("/get")
    public QuestionGetResponse questionGet() {
        return questionGetService.execute();
    }
}
