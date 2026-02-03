package com.example.falleterbev2.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ItemNotFound(404, "해당 유저의 아이템 정보를 찾을 수 없습니다");

    private final Integer status;
    private final String message;
}
