package com.example.falleterbev2.domain.comment.service;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.domain.repository.CommentRepository;
import com.example.falleterbev2.domain.comment.exception.CommentNotFoundException;
import com.example.falleterbev2.domain.comment.exception.CommentOnlyAuthorException;
import com.example.falleterbev2.domain.comment.presentation.dto.request.CommentUpdateRequest;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    public void updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        if(!comment.getUser().getId().equals(userFacade.currentUserId())) {
            throw CommentOnlyAuthorException.EXCEPTION;
        }

        comment.update(commentUpdateRequest.getContent());
        commentRepository.save(comment);

    }
}
