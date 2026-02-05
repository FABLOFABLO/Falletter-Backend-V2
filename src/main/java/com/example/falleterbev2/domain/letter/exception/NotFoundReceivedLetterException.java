package com.example.falleterbev2.domain.letter.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundReceivedLetterException extends CommonException {
    public static final NotFoundReceivedLetterException EXCEPTION = new NotFoundReceivedLetterException();
    public NotFoundReceivedLetterException() {
        super(ErrorCode.NotFoundReceivedLetter);
    }
}
