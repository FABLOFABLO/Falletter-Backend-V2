package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.response.LetterFindSentResponse;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LettersFindSentService {
    private final LetterRepository letterRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<LetterFindSentResponse> execute() {
        User Sender = userFacade.currentUser();
        List<Letter> letters = letterRepository.findBySender(Sender);

        return letters.stream()
                .map(letter -> new LetterFindSentResponse(
                        letter.getId(),
                        letter.getReceiver().getName(),
                        letter.getReceiver().getBatch(),
                        letter.getCreatedAt()
                ))
                .toList();
    }
}
