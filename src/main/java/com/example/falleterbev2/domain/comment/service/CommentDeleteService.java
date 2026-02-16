package com.example.falleterbev2.domain.comment.service;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.domain.repository.CommentRepository;
import com.example.falleterbev2.domain.comment.exception.CommentNotFoundException;
import com.example.falleterbev2.domain.comment.exception.CommentOnlyAuthorDeleteException;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentDeleteService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        if (!comment.getUser().getId().equals(userFacade.currentUserId())) {
            throw CommentOnlyAuthorDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
