package com.example.falleterbev2.domain.letter.presentation;

import com.example.falleterbev2.domain.letter.presentation.dto.request.LettersRequest;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindSentResponse;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersResponse;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindReceivedResponse;
import com.example.falleterbev2.domain.letter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.falleterbev2.domain.letter.service.LettersFindReceivedService;
import com.example.falleterbev2.domain.letter.service.LettersFindSentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/letters")
@RequiredArgsConstructor
public class LetterController {
    private final LettersSendService lettersSendService;
    private final LettersFindReceivedService lettersFindReceivedService;
    private final LettersFindSentService lettersFindSentService;
    private final LetterReadReceivedService letterReadReceivedService;
    private final LetterReadSentService letterReadSentService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void sendLetter(@RequestBody LettersRequest lettersSendRequest) {
        lettersSendService.execute(lettersSendRequest);
    }

    @GetMapping("/get-list/received")
    @ResponseStatus(HttpStatus.OK)
    public List<LettersFindReceivedResponse> findLettersReceived() {
        return lettersFindReceivedService.execute();
    }

    @GetMapping("/get-list/send")
    @ResponseStatus(HttpStatus.OK)
    public List<LettersFindSentResponse> findLettersSend() {
        return lettersFindSentService.execute();
    }

    @GetMapping("/received/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LettersResponse readReceivedLetter(@PathVariable Long id) {
        return letterReadReceivedService.execute(id);
    }

    @GetMapping("/sent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LettersResponse readSentLetter(@PathVariable Long id) {
        return letterReadSentService.execute(id);
    }
}
