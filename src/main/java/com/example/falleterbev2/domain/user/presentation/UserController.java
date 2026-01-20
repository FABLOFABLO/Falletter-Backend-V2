package com.example.falleterbev2.domain.user.presentation;

import com.example.falleterbev2.domain.user.presentation.dto.LoginRequest;
import com.example.falleterbev2.domain.user.presentation.dto.LoginResponse;
import com.example.falleterbev2.domain.user.presentation.dto.SignupRequest;
import com.example.falleterbev2.domain.user.service.LoginService;
import com.example.falleterbev2.domain.user.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody SignupRequest request) {
        signupService.singUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
