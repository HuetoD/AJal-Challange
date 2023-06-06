package com.ajal.service;

import com.ajal.dto.request.BasicUserRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService extends UserDetailsService {

    @Transactional(readOnly = true, rollbackFor = AuthenticationException.class)
    HttpHeaders loadUserAndGenerateToken(BasicUserRequest userRequest) throws AuthenticationException;

    @Override
    @Transactional(readOnly = true, rollbackFor = UsernameNotFoundException.class)
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
