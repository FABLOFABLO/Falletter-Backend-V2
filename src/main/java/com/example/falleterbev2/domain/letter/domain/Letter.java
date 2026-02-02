package com.example.falleterbev2.domain.letter.domain;

import com.example.falleterbev2.domain.user.domain.User;
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

public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipient_id" , nullable = false)
    private User receiverId;

    @ManyToOne
    @JoinColumn(name = "sender_id" , nullable = false)
    private User senderId;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(name ="created_at", nullable = false)
    private LocalDateTime createdAt;
}
