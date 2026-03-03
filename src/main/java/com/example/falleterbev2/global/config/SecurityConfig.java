package com.example.falleterbev2.global.config;

import com.example.falleterbev2.global.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        //feed
                        .requestMatchers(HttpMethod.POST, "/feed/create").authenticated()
                        .requestMatchers(HttpMethod.GET, "/feed/readAll").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/feed/update/{feed-id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/feed/delete/{feed-id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/feed/readDetail/{feed-id}").authenticated()

                        //user
                        .requestMatchers(HttpMethod.POST,"/user/signup").permitAll()
                        .requestMatchers(HttpMethod.POST,"/user/login").permitAll()
                        //item
                        .requestMatchers(HttpMethod.GET, "/item/amount").authenticated()
                        //letters
                        .requestMatchers(HttpMethod.POST, "/letters/send").authenticated()
                        .requestMatchers(HttpMethod.GET, "/letters/get-list/received").authenticated()
                        .requestMatchers(HttpMethod.GET, "/letters/get-list/send").authenticated()
                        .requestMatchers(HttpMethod.GET, "/letters/received/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/letters/sent/{id}").authenticated()

                        //comment
                        .requestMatchers(HttpMethod.POST, "/comment/{feed-id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/comment/delete/{feed-id}").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/comment/update/{feed-id}").authenticated()

                        .anyRequest().permitAll()
                )
                .addFilterBefore(
                        jwtTokenFilter,
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
