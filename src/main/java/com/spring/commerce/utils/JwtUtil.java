package com.spring.commerce.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
public class JwtUtil {

    private Key key;

    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(long userId, String name, Long itemId) {

        JwtBuilder builder = Jwts.builder()
                .claim("userId", userId)
                .claim("name", name);

        // 판매자일 경우
        if(itemId != null) {
            builder = builder.claim("itemId", itemId);
        }

        return builder
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token) // jws : sign이 포함된 jwt
                .getBody();
    }
}
