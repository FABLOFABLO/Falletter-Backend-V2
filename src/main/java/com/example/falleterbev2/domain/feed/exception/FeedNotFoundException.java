package com.example.falleterbev2.domain.feed.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeedNotFoundException extends CommonException {
    public static final FeedNotFoundException EXCEPTION = new FeedNotFoundException();
    public FeedNotFoundException() {
        super(ErrorCode.FeedNotFound);
    }
}
