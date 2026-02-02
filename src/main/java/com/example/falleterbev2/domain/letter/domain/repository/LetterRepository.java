package com.example.falleterbev2.domain.letter.domain.repository;

import com.example.falleterbev2.domain.letter.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllByReceiverId(Long receiverId);
}
