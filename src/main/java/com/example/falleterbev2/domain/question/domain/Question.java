package com.example.falleterbev2.domain.question.domain;

import com.example.falleterbev2.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_one", nullable = false)
    private User userOne;
    @Column(name = "user_one_name", nullable = false)
    private String userOneName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_two", nullable = false)
    private User userTwo;
    @Column(name = "user_two_name", nullable = false)
    private String userTwoName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_three", nullable = false)
    private User userThree;
    @Column(name = "user_three_name", nullable = false)
    private String userThreeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_four", nullable = false)
    private User userFour;
    @Column(name = "user_four_name", nullable = false)
    private String userFourName;

    @Builder
    public Question(String question, User userOne, String userOneName, User userTwo, String userTwoName, User userThree, String userThreeName, User userFour, String userFourName) {
        this.question = question;
        this.userOne = userOne;
        this.userOneName = userOneName;
        this.userTwo = userTwo;
        this.userTwoName = userTwoName;
        this.userThree = userThree;
        this.userThreeName = userThreeName;
        this.userFour = userFour;
        this.userFourName = userFourName;
    }
}
