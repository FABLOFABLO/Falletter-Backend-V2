package com.example.falleterbev2.domain.letter.domain.repository;

import com.example.falleterbev2.domain.letter.domain.Letter;
import com.example.falleterbev2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByReceiver(User receiver);
    List<Letter> findBySender(User sender);
}
