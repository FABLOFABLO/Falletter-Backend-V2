package com.example.falleterbev2.domain.feed.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedRequest {
    @NotBlank(message = "제목은 비어있을 수 없습니다")
    @Size(max = 100, min = 1, message = "최소 1자 ~ 최대 100자")
    private String title;

    @NotBlank(message = "내용은 비어있을 수 없습니다")
    @Size(max = 512, min = 1,message = "최소 1자 ~ 최대 512자")
    private String content;
}
