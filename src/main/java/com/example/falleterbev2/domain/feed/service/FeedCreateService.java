package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedCreateService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public void execute(FeedRequest feedRequest) {
        User user = userFacade.currentUser();
        feedRepository.save(
                Feed.builder()
                        .user(user)
                        .title(feedRequest.getTitle())
                        .content(feedRequest.getContent())
                        .build()
        );
    }
}
