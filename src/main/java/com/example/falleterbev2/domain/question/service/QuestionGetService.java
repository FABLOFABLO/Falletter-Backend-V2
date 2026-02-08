package com.example.falleterbev2.domain.question.service;

import com.example.falleterbev2.domain.question.domain.Question;
import com.example.falleterbev2.domain.question.domain.QuestionList;
import com.example.falleterbev2.domain.question.domain.repository.QuestionRepository;
import com.example.falleterbev2.domain.question.exception.UserNotEnoughException;
import com.example.falleterbev2.domain.question.presentation.dto.response.QuestionGetResponse;
import com.example.falleterbev2.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionGetService {
    private final QuestionRepository questionRepository;
    private final QuestionList questionList;

    public QuestionGetResponse execute() {
        List<User> randomUser = questionRepository.GetRandomUsers();
        if(randomUser.size() < 4) {
            throw UserNotEnoughException.EXCEPTION;
        }

        Question question = Question.builder()
                .question(questionList.getQuestion())
                .userOne(randomUser.get(0))
                .userOneName(randomUser.get(0).getName())
                .userTwo(randomUser.get(1))
                .userTwoName(randomUser.get(1).getName())
                .userThree(randomUser.get(2))
                .userThreeName(randomUser.get(2).getName())
                .userFour(randomUser.get(3))
                .userFourName(randomUser.get(3).getName())
                .build();

        Long id = questionRepository.save(question).getId();
        return new QuestionGetResponse(id);
    }
}
