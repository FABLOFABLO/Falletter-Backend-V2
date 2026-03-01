package com.example.falleterbev2.domain.comment.service;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.domain.repository.CommentRepository;
import com.example.falleterbev2.domain.comment.presentation.dto.request.CommentRequest;
import com.example.falleterbev2.domain.feed.domain.Feed;
import com.example.falleterbev2.domain.feed.domain.repository.FeedRepository;
import com.example.falleterbev2.domain.feed.exception.FeedNotFoundException;
import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentCreateService {
    private final CommentRepository commentRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long feedId, CommentRequest request) {
        User user = userFacade.currentUser();
        Feed feed = feedRepository.findById(feedId).orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .feed(feed)
                        .content(request.getContent())
                .build());
    }
}
