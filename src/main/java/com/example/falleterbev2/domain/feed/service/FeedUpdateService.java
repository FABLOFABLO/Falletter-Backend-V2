package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.exception.FeedNotFoundException;
import com.example.falleterbev2.domain.feed.exception.OnlyAuthorUpdateFeedException;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedUpdateService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long feedId, FeedRequest feedRequest) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);
        User user = userFacade.currentUser();

        if(!(feed.getUser() == user)) {
            throw OnlyAuthorUpdateFeedException.EXCEPTION;
        }

        feed.update(feedRequest);
    }
}
