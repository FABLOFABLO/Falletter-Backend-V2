package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FeedCreateService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    public void execute(FeedRequest feedRequest) {
        User user = userFacade.currentUser();
        feedRepository.save(
                Feed.builder()
                        .user(user)
                        .title(feedRequest.getTitle())
                        .content(feedRequest.getContent())
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}
