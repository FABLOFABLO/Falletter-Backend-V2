package com.example.falleterbev2.domain.item.presentation.dto.response;

import com.example.falleterbev2.domain.item.domain.Item;
import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private Long brickAmount;
    private Long letterAmount;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.brickAmount = item.getBrickAmount();
        this.letterAmount = item.getLetterAmount();
    }
}
