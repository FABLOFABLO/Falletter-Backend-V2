package com.example.falleterbev2.domain.user.service;

import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import com.example.falleterbev2.domain.user.presentation.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void singUp(SignupRequest request) {
        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .birth(request.getBirth())
                        .batch(request.getBatch())
                        .gender(request.getGender())
                        .build()
        );
    }
}
