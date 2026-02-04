package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.presentation.dto.reponse.FeedAllResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedReadAllService {
    private final FeedRepository feedRepository;

    @Transactional
    public List<FeedAllResponse> execute() {
        List<Feed> feeds = feedRepository.findAllFeeds();

        List<FeedAllResponse> feedAllResponses = feeds.stream()
                .map(feed ->
                        FeedAllResponse.builder()
                                .userId(feed.getUser().getId())
                                .feedId(feed.getId())
                                .author(feed.getUser().getName())
                                .title(feed.getTitle())
                                .content(feed.getContent())
                                .createdAt(feed.getCreatedAt())
                                .build()
                ).toList();
        return feedAllResponses;
    }
}
