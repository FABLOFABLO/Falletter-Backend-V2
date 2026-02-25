package com.example.falleterbev2.domain.feed.domain;

import com.example.falleterbev2.domain.comment.domain.Comment;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_feed")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "comment_count", nullable = false)
    private Long commentCount = 0L;

    public void update(FeedRequest feedRequest) {
        this.title = feedRequest.getTitle();
        this.content = feedRequest.getContent();
    }

    public void countUp() {
//        if (this.commentCount == null) {
//            this.commentCount = 0L;
//        }
        this.commentCount += 1;
    }

    public void countDown() {
        if (this.commentCount == null || this.commentCount <= 0) {
            this.commentCount = 0L;
            return;
        }
        this.commentCount -= 1;
    }

    @Builder
    public Feed(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
