package com.example.falleterbev2.domain.letter.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "tbl_letter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity

public class letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(name ="created_at", nullable = false)
    private LocalDateTime createdAt;
}
