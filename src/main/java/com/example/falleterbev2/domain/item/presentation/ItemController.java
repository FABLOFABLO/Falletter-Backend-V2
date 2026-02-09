package com.example.falleterbev2.domain.item.presentation;

import com.example.falleterbev2.domain.item.presentation.dto.response.ItemResponse;
import com.example.falleterbev2.domain.item.service.ItemAmountReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemAmountReadService itemAmountReadService;

    @GetMapping("/amount")
    @ResponseStatus(HttpStatus.OK)
    public ItemResponse getItemAmount() {
        return itemAmountReadService.execute();
    }
}
