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
    @JoinColumn(name = "first_user", nullable = false)
    private User firstUser;
    @Column(name = "first_user_name", nullable = false)
    private String firstUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_user", nullable = false)
    private User secondUser;
    @Column(name = "second_user_name", nullable = false)
    private String secondUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "third_user", nullable = false)
    private User thirdUser;
    @Column(name = "third_user_name", nullable = false)
    private String thirdUserName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fourth_user", nullable = false)
    private User fourthUser;
    @Column(name = "fourth_user_name", nullable = false)
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
