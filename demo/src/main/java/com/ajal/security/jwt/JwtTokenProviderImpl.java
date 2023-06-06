package com.ajal.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProviderImpl implements JwtTokenProvider, InitializingBean {

    @Value("ajal.jwt.secret")
    private String secretKey;

    @Value("ajal.jwt.issuer")
    private String issuer;

    @Value("ajal.jwt.expiration")
    private int expirationSeconds;

    private Algorithm algorithm;

    @Override
    public String generateJwtToken(UserDetails userDetails) {
        Date now = new Date();
        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + expirationSeconds * 1000))
                .sign(algorithm);
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request, String email) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                =  new UsernamePasswordAuthenticationToken(email, null, null);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean isTokenValid(String email, String token) {
        return !email.isEmpty() && hasTokenNotExpired(token);
    }

    @Override
    public String getSubject(String token) {
        return verifier().verify(token).getSubject();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        algorithm = Algorithm.HMAC512(secretKey.getBytes());
    }

    private JWTVerifier verifier() {
        JWTVerifier verifier = null;
        try {
            verifier = JWT.require(algorithm).withIssuer(issuer).build();
        }catch(JWTVerificationException exception) {
            throw new JWTVerificationException("Su token no puede ser verificado");
        }
        return verifier;
    }

    private boolean hasTokenNotExpired(String token) {
        return verifier().verify(token).getExpiresAt().after(new Date());
    }
}
