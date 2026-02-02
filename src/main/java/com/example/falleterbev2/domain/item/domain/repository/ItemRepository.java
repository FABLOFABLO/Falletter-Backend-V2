package com.example.falleterbev2.domain.item.domain.repository;

import com.example.falleterbev2.domain.item.domain.Item;
import com.example.falleterbev2.domain.item.presentation.dto.response.ItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByUserId(Long userId);
    ItemResponse findById(Item item);
}
