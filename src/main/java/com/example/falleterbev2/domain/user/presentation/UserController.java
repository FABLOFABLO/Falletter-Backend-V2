package com.example.falleterbev2.domain.user.presentation;

import com.example.falleterbev2.domain.user.presentation.dto.SignupRequest;
import com.example.falleterbev2.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SignupService signupService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Validated @RequestBody SignupRequest signupRequest) {
        signupService.singUp(signupRequest);
    }

}
