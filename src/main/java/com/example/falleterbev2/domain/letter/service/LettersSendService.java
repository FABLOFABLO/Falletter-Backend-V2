package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.request.LettersSendRequest;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LettersSendService {
    private final LetterRepository letterRepository;
    private final UserFacade userFacade;

    public void sendLetter(LettersSendRequest request) {
        Letter letter = Letter.builder()
                .content(request.getContent())
                .build();
        letterRepository.save(letter);
    }
}
