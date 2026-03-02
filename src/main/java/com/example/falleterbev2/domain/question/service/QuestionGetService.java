package com.example.falleterbev2.domain.question.service;

import com.example.falleterbev2.domain.question.domain.Question;
import com.example.falleterbev2.domain.question.domain.QuestionList;
import com.example.falleterbev2.domain.question.domain.repository.QuestionRepository;
import com.example.falleterbev2.domain.question.exception.UserNotEnoughException;
import com.example.falleterbev2.domain.question.presentation.dto.response.QuestionGetResponse;
import com.example.falleterbev2.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionGetService {
    private final QuestionRepository questionRepository;
    private final QuestionList questionList;

    @Transactional
    public QuestionGetResponse execute() {
        List<User> randomUser = questionRepository.GetRandomUsers();
        if(randomUser.size() < 4) {
            throw UserNotEnoughException.EXCEPTION;
        }

        Question question = Question.builder()
                .question(questionList.getQuestion())
                .firstUser(randomUser.get(0))
                .firstUserName(randomUser.get(0).getName())
                .secondUser(randomUser.get(1))
                .secondUserName(randomUser.get(1).getName())
                .thirdUser(randomUser.get(2))
                .thirdUserName(randomUser.get(2).getName())
                .fourthUser(randomUser.get(3))
                .fourthUserName(randomUser.get(3).getName())
                .build();

        Long id = questionRepository.save(question).getId();
        return new QuestionGetResponse(id);
    }
}
