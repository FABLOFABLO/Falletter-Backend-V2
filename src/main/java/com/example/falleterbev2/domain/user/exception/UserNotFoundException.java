package com.example.falleterbev2.domain.user.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends CommonException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException() {
        super(ErrorCode.UserNotFound);
    }
}