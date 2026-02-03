package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LettersFindReceivedResponse;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LettersFindReceivedService {
    private final LetterRepository letterRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<LettersFindReceivedResponse> findLettersReceived() {
        Long receiverId = userFacade.currentUserId();
        List<Letter> letters = letterRepository.findByReceiverId(receiverId);

        return letters.stream()
                .map(letter -> new LettersFindReceivedResponse(
                        letter.getId(),
                        letter.getContent(),
                        letter.getCreatedAt()
                ))
                .toList();
    }
}
