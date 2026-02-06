package com.example.falleterbev2.domain.comment.presentation;

import com.example.falleterbev2.domain.comment.presentation.dto.request.CommentCreateRequest;
import com.example.falleterbev2.domain.comment.service.CommentCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;

    @PostMapping("/{feedId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable Long feedId, @RequestBody CommentCreateRequest commentCreateRequest) {
        commentCreateService.createComment(feedId, commentCreateRequest);
    }
}
