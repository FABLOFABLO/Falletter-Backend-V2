package com.example.falleterbev2.domain.user.service;

import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import com.example.falleterbev2.domain.user.presentation.dto.LoginRequest;
import com.example.falleterbev2.domain.user.presentation.dto.LoginResponse;
import com.example.falleterbev2.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByName(request.getEmail())
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호 불일치");
        }

        String accessToken =
                jwtTokenProvider.generateAccessToken(user.getEmail(), user.getRole());

        String refreshToken =
                jwtTokenProvider.generateRefreshToken(user.getEmail(), user.getRole());

        return new LoginResponse(accessToken, refreshToken);
    }
}
