package com.example.falleterbev2.domain.comment.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;

public class CommentOnlyAuthorDeleteException extends CommonException {
    public static final CommentOnlyAuthorDeleteException EXCEPTION = new CommentOnlyAuthorDeleteException();
    public CommentOnlyAuthorDeleteException() {
        super(ErrorCode.CommentOnlyAuthorDelete);
    }
}
