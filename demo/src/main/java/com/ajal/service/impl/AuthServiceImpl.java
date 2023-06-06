package com.ajal.service.impl;

import com.ajal.dto.request.BasicUserRequest;
import com.ajal.entity.User;
import com.ajal.repository.UserRepository;
import com.ajal.security.jwt.JwtTokenProvider;
import com.ajal.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.ajal.security.util.SecurityConstant.JWT_TOKEN_HEADER;
import static com.ajal.security.util.SecurityConstant.TOKEN_PREFIX;

@Service
public class AuthServiceImpl implements AuthService {

    public final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public HttpHeaders loadUserAndGenerateToken(BasicUserRequest userRequest) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword())
        );
        String token = jwtTokenProvider.generateJwtToken(loadUserByUsername(userRequest.getEmail()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", JWT_TOKEN_HEADER);
        headers.add(JWT_TOKEN_HEADER, TOKEN_PREFIX + token);
        return headers;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con correo " + email + " no existe"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                null
        );
    }
}
