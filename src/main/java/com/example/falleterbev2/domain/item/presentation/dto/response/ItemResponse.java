package com.example.falleterbev2.domain.item.presentation.dto.response;

import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private Long brickAmount;
    private Long letterAmount;

    public ItemResponse(Long id, Long brickAmount, Long letterAmount) {
        this.id = id;
        this.brickAmount = brickAmount;
        this.letterAmount = letterAmount;
    }
}
