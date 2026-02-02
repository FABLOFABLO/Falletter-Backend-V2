package com.example.falleterbev2.domain.letter.presentation;

import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindReceivedResponse;
import com.example.falleterbev2.domain.letter.service.LettersFindReceivedService;
import com.example.falleterbev2.domain.letter.service.LettersFindSentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/letters")
@RequiredArgsConstructor
public class LetterController {
    private final LettersFindReceivedService lettersFindReceivedService;
    private final LettersFindSentService lettersFindSentService;

    @GetMapping("/received")
    public List<LettersFindReceivedResponse> findLettersReceived() {
        return lettersFindReceivedService.findLettersReceived();
    }
}
