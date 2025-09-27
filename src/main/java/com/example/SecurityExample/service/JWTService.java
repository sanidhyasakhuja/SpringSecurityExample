package com.example.SecurityExample.service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	private String secretKey;
	
	public JWTService() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sKey =keyGenerator.generateKey();
			secretKey=Base64.getEncoder().encodeToString(sKey.getEncoded());
			System.out.println("SecretKey:"+secretKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return Jwts.builder()
		    .claims()
		    .add(claims)
		    .subject(username)
		    .issuedAt(new Date(System.currentTimeMillis()))
		    .expiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY *1000))
		    .and()
		    .signWith(getKey())
		    .compact();
		
	}

	private SecretKey getKey() {
		byte [] keyBytes = Base64.getDecoder().decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
