package com.example.falleterbev2.domain.letter.domain.repository;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByReceiver(User receiver);
    List<Letter> findBySender(User sender);
}
