package com.example.falleterbev2.global.detail;

import com.example.falleterbev2.domain.user.domain.User;
import com.example.falleterbev2.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DetailService implements UserDetailsService {

    private final UserRepository userRepository;//UserdetailsService는 시큐리티에서 이미 만들어놓은 인터페이스이다.

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("찾을 수 없는 사용자입니다." + name));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

}

