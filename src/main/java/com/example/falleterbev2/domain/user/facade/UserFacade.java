package com.example.falleterbev2.domain.user.facade;

import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import com.example.falleterbev2.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public Long currentUserId() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION).getId();
    }

    public User currentUser() {
        Long userId = currentUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
        return user;
    }
}
