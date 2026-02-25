package com.example.falleterbev2.domain.feed.service;

import com.example.falleterbev2.domain.comment.presentation.dto.CommentResponse;
import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.exception.FeedNotFoundException;
import com.example.falleterbev2.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedReadDetailService {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse execute(Long id) {
        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        List<CommentResponse> commentResponseList = feed.getComments()
                .stream()
                .map(comment ->
                        new CommentResponse(comment))
                .toList();

        return new FeedDetailResponse(feed, commentResponseList);
    }
}
