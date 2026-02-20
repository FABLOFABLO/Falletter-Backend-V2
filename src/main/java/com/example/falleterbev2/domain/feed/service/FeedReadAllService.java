package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.presentation.dto.response.FeedAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedReadAllService {
    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<FeedAllResponse> execute() {
        List<Feed> feeds = feedRepository.findAllFeeds();

        List<FeedAllResponse> feedAllResponses = feeds.stream()
                .map(feed ->
                        new FeedAllResponse(feed)
                ).toList();
        return feedAllResponses;
    }
}
