package com.example.falleterbev2.domain.question.domain;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;

@Component
public class QuestionList {
    private final List<String> questions = List.of(
            "조금 집가고 싶을 것 같은 사람",
            "정말 집가고 싶을 것 같은 사람",
            "백엔드 전공 일 것 같은 사람",
            "AI 전공 일 것 같은 사람",
            "프론트엔드 전공일 것 같은 사람",
            "MBTI I일 것 같은 사람",
            "MBTI E일 것 같은 사람"
    );

    static Random random = new Random();
    public String getQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}
