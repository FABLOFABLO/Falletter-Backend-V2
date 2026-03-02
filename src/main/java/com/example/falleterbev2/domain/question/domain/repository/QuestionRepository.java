package com.example.falleterbev2.domain.question.domain.repository;

import com.example.falleterbev2.domain.question.domain.Question;
import com.example.falleterbev2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT * FROM tbl_user ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<User> GetRandomUsers();
}
