package com.spring.commerce.utils;

import com.spring.commerce.domain.enums.UserLevel;
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

    // TODO ACCESS TOKEN 생명주기, REFRESH TOKEN 설계

    private Key key;

    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(long userId, String email, String name, UserLevel userLevel) {

        JwtBuilder builder = Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("name", name)
                .claim("level", userLevel);

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
