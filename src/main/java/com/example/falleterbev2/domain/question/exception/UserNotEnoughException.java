package com.example.falleterbev2.domain.question.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserNotEnoughException extends CommonException {
    public static final UserNotEnoughException EXCEPTION = new UserNotEnoughException();
    public UserNotEnoughException() {
        super(ErrorCode.UserNotEnough);
    }
}
