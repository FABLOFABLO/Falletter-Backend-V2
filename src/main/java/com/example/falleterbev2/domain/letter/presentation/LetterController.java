package com.example.falleterbev2.domain.letter.presentation;

import com.example.falleterbev2.domain.letter.presentation.dto.request.LettersSendRequest;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LetterFindSentResponse;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindReceivedResponse;
import com.example.falleterbev2.domain.letter.service.LettersFindReceivedService;
import com.example.falleterbev2.domain.letter.service.LettersSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letters")
@RequiredArgsConstructor
public class LetterController {
    private final LettersSendService lettersSendService;
    private final LettersFindReceivedService lettersFindReceivedService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void sendLetter(@RequestBody LettersSendRequest lettersSendRequest) {
        lettersSendService.sendLetter(lettersSendRequest);
    }

    @GetMapping("/get-list/received")
    @ResponseStatus(HttpStatus.OK)
    public List<LettersFindReceivedResponse> findLettersReceived() {
        return lettersFindReceivedService.findLettersReceived();
    }
}
