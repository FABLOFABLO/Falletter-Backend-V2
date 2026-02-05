package com.example.falleterbev2.domain.letter.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundReceivedUserException extends CommonException {
    public static final NotFoundReceivedUserException EXCEPTION = new NotFoundReceivedUserException();
    public NotFoundReceivedUserException() {
        super(ErrorCode.NotFoundReceivedUser);
    }
}
