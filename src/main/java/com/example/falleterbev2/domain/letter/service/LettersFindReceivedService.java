package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindReceivedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LettersFindReceivedService {
    private final LetterRepository letterRepository;

    @Transactional(readOnly = true)
    public List<LettersFindReceivedResponse> findLettersReceived(Long userId) {
        List<Letter> letters = letterRepository.findAllByReceiverId(userId);


        return letters.stream()
                .map(letter -> new LettersFindReceivedResponse(
                        letter.getId(),
                        letter.getSenderId().getName(),
                        letter.getContent(),
                        letter.getCreatedAt()
                ))
                .toList();
    }


}
