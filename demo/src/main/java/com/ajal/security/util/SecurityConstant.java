package com.ajal.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class SecurityConstant {

    public static final String ACCESS_DENIED_MESSAGE = "No estas autenticado";
    public static final String FORBBIDEN_MESSAGE = "Necesitas autenticarte";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "__JWT_TOKEN__";

    public static final String [] PUBLIC_URLS = {
            "/swagger-ui.html",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/webjars/**"
    };

    public static void handle(HttpServletResponse response, String message, HttpStatus status) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status.value());
        OutputStream outputStream = response.getOutputStream();
        new ObjectMapper().writeValue(outputStream, new ResponseEntity<>(message, status));
        outputStream.flush();
    }

}
