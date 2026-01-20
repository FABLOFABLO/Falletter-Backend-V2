package com.example.falleterbev2.global.jwt;

import com.example.falleterbev2.domain.auth.domain.RefreshToken;
import com.example.falleterbev2.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.falleterbev2.domain.user.domain.Role;
import com.example.falleterbev2.global.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperty jwtProperty;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String accountId, Role role) {
        return generateToken(accountId, role.name(), "access", jwtProperty.getAccessExp());
    }

    public String generateRefreshToken(String accountId, Role role) {
        String refreshToken =
                generateToken(accountId, role.name(), "refresh", jwtProperty.getRefreshExp());

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .accountId(accountId)
                        .token(refreshToken)
                        .ttl(jwtProperty.getRefreshExp())
                        .build()
        );

        return refreshToken;
    }

    private String generateToken(String subject, String role, String type, Long exp) {
        return Jwts.builder()
                .setSubject(subject)
                .claim("authority", role)
                .setHeaderParam("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperty.getHeader());
        if (bearer != null && bearer.startsWith(jwtProperty.getPrefix())) {
            return bearer.substring(jwtProperty.getPrefix().length());
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails =
                authDetailsService.loadUserByUsername(getSubject(token));

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                "",
                userDetails.getAuthorities()
        );
    }
    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new BadCredentialsException("Expired or invalid JWT token");
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid token");
        }
    }

    private String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperty.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
}