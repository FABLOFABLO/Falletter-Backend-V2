package com.example.falleterbev2.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ItemNotFound(404, "해당 유저의 아이템 정보를 찾을 수 없습니다"),

    //user
    UserNotFound(404, "해당 id를 가진 유저를 찾을 수 없습니다"),

    //feed
    FeedNotFound(404, "존재하지 않는 게시물입니다"),
    OnlyAuthorUpdateFeed(403, "자신의 게시물만 삭제 가능합니다");

    private final Integer status;
    private final String message;
}
