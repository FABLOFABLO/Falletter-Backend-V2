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
    OnlyAuthorUpdateFeed(403, "자신의 게시물만 삭제 가능합니다"),

    //question
    UserNotEnough(409, "질문을 구성하기위한 유저가 부족합니다"),

    //letter
    NotFoundReceivedUser(404, "레터를 받을 유저를 찾을수 없습니다."),
    NotFoundSentUser(404, "레터를 보낸 유저를 찾을수 없습니다"),
    NotFoundReceivedLetter(404, "해당 받은 레터를 찾을수없습니다"),
    NotFoundSentLetter(404, "해당 보낸 레터를 찾을수없습니다"),

    //comment
    CommentOnlyAuthorDelete(403 , "오직 자신의 댓글만 삭제 가능합니다"),
    CommentOnlyAuthorUpdate(403 , "오직 자신의 댓글만 수정 가능합니다"),
    CommentNotFound(404 , "해당 댓글을 찾을수없습니다");


    private final Integer status;
    private final String message;
}
