package com.example.falleterbev2.domain.comment.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;

public class CommentNotFoundException extends CommonException {
    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();
    public CommentNotFoundException() {
        super(ErrorCode.CommentNotFound);
    }
}
