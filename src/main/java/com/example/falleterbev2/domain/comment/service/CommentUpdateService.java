package com.example.falleterbev2.domain.comment.service;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.domain.repository.CommentRepository;
import com.example.falleterbev2.domain.comment.exception.CommentNotFoundException;
import com.example.falleterbev2.domain.comment.exception.CommentOnlyAuthorUpdateException;
import com.example.falleterbev2.domain.comment.presentation.dto.request.CommentRequest;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    public void execute(Long commentId, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        if(!comment.getUser().getId().equals(userFacade.currentUserId())) {
            throw CommentOnlyAuthorUpdateException.EXCEPTION;
        }

        comment.update(commentRequest.getContent());
        commentRepository.save(comment);

    }
}
