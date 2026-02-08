package com.example.falleterbev2.domain.comment.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;

public class CommentOnlyAuthorUpdateException extends CommonException {
    public static final CommentOnlyAuthorUpdateException EXCEPTION = new CommentOnlyAuthorUpdateException();
    public CommentOnlyAuthorUpdateException() {
        super(ErrorCode.CommentOnlyAuthorUpdate);
    }
}
