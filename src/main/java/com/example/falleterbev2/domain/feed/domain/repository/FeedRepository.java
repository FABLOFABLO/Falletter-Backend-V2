package com.example.falleterbev2.domain.feed.domain.repository;

import com.example.falleterbev2.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    @Query("select feed from Feed feed join fetch feed.user")
    List<Feed> findAllFeeds();
}
