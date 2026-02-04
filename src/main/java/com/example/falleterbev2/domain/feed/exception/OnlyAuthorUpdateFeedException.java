package com.example.falleterbev2.domain.feed.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OnlyAuthorUpdateFeedException extends CommonException {
    public static final OnlyAuthorUpdateFeedException EXCEPTION = new OnlyAuthorUpdateFeedException();
    public OnlyAuthorUpdateFeedException() {
        super(ErrorCode.OnlyAuthorUpdateFeed);
    }
}
