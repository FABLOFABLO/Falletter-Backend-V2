package com.example.falleterbev2.domain.comment.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;

public class CommentOnlyAuthorException extends CommonException {
    public static final CommentOnlyAuthorException EXCEPTION = new CommentOnlyAuthorException();
    public CommentOnlyAuthorException() {
        super(ErrorCode.CommentOnlyAuthor);
    }
}
