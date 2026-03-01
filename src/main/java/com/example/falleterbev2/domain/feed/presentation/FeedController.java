package com.example.falleterbev2.domain.feed.presentation;

import com.example.falleterbev2.domain.feed.presentation.dto.response.FeedAllResponse;
import com.example.falleterbev2.domain.feed.presentation.dto.request.FeedRequest;
import com.example.falleterbev2.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.falleterbev2.domain.feed.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedCreateService feedCreateService;
    private final FeedReadAllService feedReadAllService;
    private final FeedUpdateService feedUpdateService;
    private final FeedDeleteService feedDeleteService;
    private final FeedReadDetailService feedReadDetailService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@Valid @RequestBody FeedRequest feedRequest) {
        feedCreateService.execute(feedRequest);
    }

    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public List<FeedAllResponse> readAllFeed() {
        return feedReadAllService.execute();
    }

    @PatchMapping("/update/{feed-id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFeed(@Valid @PathVariable("feed-id") Long feedId, @RequestBody FeedRequest feedRequest) {
        feedUpdateService.execute(feedId, feedRequest);
    }

    @DeleteMapping("/delete/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        feedDeleteService.execute(feedId);
    }

    @GetMapping("/readDetail/{feed-id}")
    @ResponseStatus(HttpStatus.OK)
    public FeedDetailResponse readDetailFeed(@PathVariable("feed-id") Long feedId) {
        return feedReadDetailService.execute(feedId);
    }
}
