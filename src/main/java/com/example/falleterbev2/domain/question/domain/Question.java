package com.example.falleterbev2.domain.question.domain;

import com.example.falleterbev2.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_question")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_one", nullable = false)
    private User firstUser;
    @Column(name = "user_one_name", nullable = false)
    private String firstUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_two", nullable = false)
    private User secondUser;
    @Column(name = "user_two_name", nullable = false)
    private String secondUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_three", nullable = false)
    private User thirdUser;
    @Column(name = "user_three_name", nullable = false)
    private String thirdUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_four", nullable = false)
    private User fourthUser;
    @Column(name = "user_four_name", nullable = false)
    private String fourthUserName;

    @Builder
    public Question(String question, User firstUser, String firstUserName, User secondUser, String secondUserName, User thirdUser, String thirdUserName, User fourthUser, String fourthUserName) {
        this.question = question;
        this.firstUser = firstUser;
        this.firstUserName = firstUserName;
        this.secondUser = secondUser;
        this.secondUserName = secondUserName;
        this.thirdUser = thirdUser;
        this.thirdUserName = thirdUserName;
        this.fourthUser = fourthUser;
        this.fourthUserName = fourthUserName;
    }
}
