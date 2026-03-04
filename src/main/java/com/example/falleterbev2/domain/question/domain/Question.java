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
    @JoinColumn(name = "first_option", nullable = false)
    private User firstOption;
    @Column(name = "first_option_name", nullable = false)
    private String firstOptionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_option", nullable = false)
    private User secondOption;
    @Column(name = "second_option_name", nullable = false)
    private String secondOptionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "third_option", nullable = false)
    private User thirdOption;
    @Column(name = "third_option_name", nullable = false)
    private String thirdOptionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fourth_option", nullable = false)
    private User fourthOption;
    @Column(name = "fourth_option_name", nullable = false)
    private String fourthOptionName;

    @Builder
    public Question(String question, User firstOption, String firstOptionName, User secondOption, String secondOptionName, User thirdOption, String thirdOptionName, User fourthOption, String fourthOptionName) {
        this.question = question;
        this.firstOption = firstOption;
        this.firstOptionName = firstOptionName;
        this.secondOption = secondOption;
        this.secondOptionName = secondOptionName;
        this.thirdOption = thirdOption;
        this.thirdOptionName = thirdOptionName;
        this.fourthOption = fourthOption;
        this.fourthOptionName = fourthOptionName;
    }
}
