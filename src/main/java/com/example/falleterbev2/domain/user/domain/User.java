package com.example.falleterbev2.domain.user.domain;

import com.example.falleterbev2.domain.item.domain.Item;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 225)
    private String password;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false, name = "student_id")
    private String batch;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false,length = 50)
    private String email;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Item item;
}
