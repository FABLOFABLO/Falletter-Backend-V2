package com.example.falleterbev2.domain.comment.service;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.comment.domain.repository.CommentRepository;
import com.example.falleterbev2.domain.comment.exception.CommentNotFoundException;
import com.example.falleterbev2.domain.comment.exception.CommentOnlyAuthorDeleteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentDeleteService {
    private final CommentRepository commentRepository;

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        Long userId = comment.getUser().getId();

        if (!comment.getUser().getId().equals(userId)) {
            throw CommentOnlyAuthorDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
