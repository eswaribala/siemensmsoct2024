package com.siemens.useraccountapi.configurations;

import com.siemens.useraccountapi.exceptions.JwtTokenMalformedException;
import com.siemens.useraccountapi.exceptions.JwtTokenMissingException;
import com.siemens.useraccountapi.models.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class JWTUtil {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.validity.time}")
    private long validityTime;

    public String generateToken(User user){
        Claims claims= Jwts.claims().setSubject(user.getUserName());
        claims.put("roles",user.getRoles());
        long startTime= System.currentTimeMillis();
        long expiryTime=startTime+validityTime;
        Date expiryTimeInDateFormat=new Date(expiryTime);
        return Jwts.builder().setClaims(claims)
                .setExpiration(expiryTimeInDateFormat)
                .setId(String.valueOf(
                        new Random().nextInt(10000,10000000)))
                .setIssuedAt(new Date(startTime))
                .signWith(SignatureAlgorithm.HS256,secretKey).compact();

    }

    public void validateToken(String token){

        try{
            System.out.println(token);
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        }
        catch (SignatureException ex) {
            throw new JwtTokenMalformedException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new JwtTokenMalformedException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenMalformedException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new JwtTokenMalformedException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new JwtTokenMissingException("JWT claims string is empty.");
        }


    }

}
