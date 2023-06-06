package com.ajal.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface JwtTokenProvider {

    String generateJwtToken(UserDetails userDetails);

    Authentication getAuthentication(HttpServletRequest request, String email);

    boolean isTokenValid(String email, String token);

    String getSubject(String token);
}
