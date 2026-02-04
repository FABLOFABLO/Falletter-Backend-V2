package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LetterReadSentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterReadSentService {
    private final LetterRepository letterRepository;

    public LetterReadSentResponse readSentLetter(Long id) {
        Letter letter = letterRepository.findById(id)
                .orElseThrow();
        return new LetterReadSentResponse(letter);
    }

}
