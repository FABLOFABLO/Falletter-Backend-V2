package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.exception.NotFoundSentLetterException;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LetterReadSentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LetterReadSentService {
    private final LetterRepository letterRepository;

    @Transactional
    public LetterReadSentResponse execute(Long id) {
        Letter letter = letterRepository.findById(id)
                .orElseThrow(() -> NotFoundSentLetterException.EXCEPTION);
        return new LetterReadSentResponse(letter);
    }
}
