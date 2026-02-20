package com.example.falleterbev2.domain.comment.presentation;

import com.example.falleterbev2.domain.comment.presentation.dto.request.CommentRequest;
import com.example.falleterbev2.domain.comment.service.CommentCreateService;
import com.example.falleterbev2.domain.comment.service.CommentDeleteService;
import com.example.falleterbev2.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentDeleteService commentDeleteService;
    private final CommentUpdateService commentUpdateService;

    @PostMapping("/{feedId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable Long feedId, @RequestBody CommentRequest commentCreateRequest) {
        commentCreateService.execute(feedId, commentCreateRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id) {
        commentDeleteService.execute(id);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable Long id,@RequestBody CommentRequest commentRequest) {
        commentUpdateService.execute(id, commentRequest);
    }
}
