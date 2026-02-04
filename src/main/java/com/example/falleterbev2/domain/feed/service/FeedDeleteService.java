package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.exception.FeedNotFoundException;
import com.example.falleterbev2.domain.feed.exception.OnlyAuthorUpdateFeedException;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedDeleteService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    public void execute(Long feedId) {
        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);
        if(!(feed.getUser() == userFacade.currentUser()))
        {
            throw OnlyAuthorUpdateFeedException.EXCEPTION;
        }

        feedRepository.deleteById(feedId);
    }
}
