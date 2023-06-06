package com.ajal.security.filter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ajal.security.util.SecurityConstant.handle;
import static com.ajal.security.util.SecurityConstant.FORBBIDEN_MESSAGE;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException {
        handle(response, FORBBIDEN_MESSAGE, FORBIDDEN);
    }
}
