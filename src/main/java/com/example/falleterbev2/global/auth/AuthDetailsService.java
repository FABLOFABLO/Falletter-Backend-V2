package com.example.falleterbev2.global.auth;

import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        return userRepository.findByName(accountId)
                .map(AuthDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(accountId));
    }

}
