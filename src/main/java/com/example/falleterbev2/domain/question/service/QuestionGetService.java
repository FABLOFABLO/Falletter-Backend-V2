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
                .firstOption(randomUser.get(0))
                .firstOptionName(randomUser.get(0).getName())
                .secondOption(randomUser.get(1))
                .secondOptionName(randomUser.get(1).getName())
                .thirdOption(randomUser.get(2))
                .thirdOptionName(randomUser.get(2).getName())
                .fourthOption(randomUser.get(3))
                .fourthOptionName(randomUser.get(3).getName())
                .build();

        Long id = questionRepository.save(question).getId();
        return new QuestionGetResponse(id);
    }
}
