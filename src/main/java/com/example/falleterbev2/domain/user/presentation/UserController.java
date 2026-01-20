package com.example.falleterbev2.domain.user.presentation;

import com.example.falleterbev2.domain.user.presentation.dto.SignupRequest;
import com.example.falleterbev2.domain.user.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest request) {
        signupService.singUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
