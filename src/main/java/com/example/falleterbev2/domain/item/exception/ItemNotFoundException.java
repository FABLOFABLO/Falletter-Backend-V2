package com.example.falleterbev2.domain.item.exception;

import com.example.falleterbev2.global.error.exception.CommonException;
import com.example.falleterbev2.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends CommonException {
    public static final ItemNotFoundException EXCEPTION = new ItemNotFoundException();
    public ItemNotFoundException() {
        super(ErrorCode.ItemNotFound);
    }
}
