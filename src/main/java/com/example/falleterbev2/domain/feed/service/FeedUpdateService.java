package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.exception.FeedNotFoundException;
import com.example.falleterbev2.domain.feed.exception.OnlyAuthorUpdateFeedException;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
