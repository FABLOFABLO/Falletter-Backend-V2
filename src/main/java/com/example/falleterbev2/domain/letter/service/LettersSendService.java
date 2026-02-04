package com.example.falleterbev2.domain.letter.service;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.letter.domain.repository.LetterRepository;
import com.example.falleterbev2.domain.letter.presentation.dto.request.LettersSendRequest;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LettersSendService {

    private final LetterRepository letterRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void sendLetter(LettersSendRequest request) {

        User sender = userRepository.findById(userFacade.currentUserId())
                .orElseThrow(() -> new IllegalArgumentException("보낸 유저 없음"));

        User receiver = userRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new IllegalArgumentException("받는 유저 없음"));

        Letter letter = Letter.builder()
                .sender(sender)
                .receiver(receiver)
                .content(request.getContent())
                .build();

        letterRepository.save(letter);
    }
}
