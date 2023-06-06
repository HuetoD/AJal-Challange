package com.ajal.controller;

import com.ajal.dto.request.BasicUserRequest;
import com.ajal.dto.response.GenericStringResponse;
import com.ajal.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ajal/v1/auth/")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody BasicUserRequest userRequest) {
        return new ResponseEntity<>("Usuario autenticado", authService.loadUserAndGenerateToken(userRequest), HttpStatus.OK);
    }

}
