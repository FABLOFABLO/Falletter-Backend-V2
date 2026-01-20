package com.example.falleterbev2.domain.auth.domain.repository;

import com.example.falleterbev2.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
