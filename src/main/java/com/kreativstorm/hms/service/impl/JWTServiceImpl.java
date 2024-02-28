package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 + 60 * 24000))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserName(String token){
        return extratClaim(token, Claims::getSubject);
    }

    private <T> T extratClaim(String Token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(Token);
        return claimsResolver.apply(claims);
    }

    private Key getSigninKey(){
        byte[] key = Decoders.BASE64.decode("413F4428472B4B6250655368566D597033733676397924422645294840404D6351");
        return Keys.hmacShaKeyFor(key);

    }

    private Claims extractAllClaims(String token){
        try {
            return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
        }catch(ExpiredJwtException exc){
            throw new ClientException(exc.getMessage());
        }

    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return  (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public String generateRefreshToken(HashMap<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private boolean isTokenExpired(String token){
            return  extratClaim(token, Claims::getExpiration).before(new Date());
    }
}
