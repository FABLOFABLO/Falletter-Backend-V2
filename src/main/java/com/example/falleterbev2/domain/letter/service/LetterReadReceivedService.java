package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.exception.NotFoundReceivedLetterException;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LetterReadReceivedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LetterReadReceivedService {
    private final LetterRepository letterRepository;

    @Transactional(readOnly = true)
    public LetterReadReceivedResponse readReceivedLetter(Long id) {
        Letter letter = letterRepository.findById(id)
                .orElseThrow(() -> NotFoundReceivedLetterException.EXCEPTION);
        return new LetterReadReceivedResponse(letter);
    }
}
