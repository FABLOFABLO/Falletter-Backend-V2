package com.example.falleterbev2.domain.item.service;

import com.example.falleterbev2.domain.item.domain.Item;
import com.example.falleterbev2.domain.item.domain.repository.ItemRepository;
import com.example.falleterbev2.domain.item.exception.ItemNotFoundException;
import com.example.falleterbev2.domain.item.presentation.dto.response.ItemResponse;
import com.example.falleterbev2.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemAmountReadService {
    private final ItemRepository itemRepository;
    private final UserFacade userFacade;

    @Transactional
    public ItemResponse execute() {
        Long userId = userFacade.currentUserId();
        Item item = itemRepository.findByUserId(userId).orElseThrow(()-> ItemNotFoundException.EXCEPTION);
        return new ItemResponse(item);
    }
}
