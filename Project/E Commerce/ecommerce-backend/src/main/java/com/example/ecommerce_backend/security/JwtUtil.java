package com.example.ecommerce_backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey12345"; // min 32 chars
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ✅ Generate Token
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)                     // ✅ new method
                .issuedAt(new Date())                  // ✅ new method
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)                         // ✅ new method (NO algorithm param)
                .compact();
    }

    // ✅ Extract Username
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ Validate Token
    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    // ✅ Token Expiry
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // ✅ Claims Extraction (NEW API)
    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)   // ✅ new parser style
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
