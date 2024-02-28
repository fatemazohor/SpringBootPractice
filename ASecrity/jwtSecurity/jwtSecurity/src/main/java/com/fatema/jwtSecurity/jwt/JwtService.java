package com.fatema.jwtSecurity.jwt;

import com.fatema.jwtSecurity.model.User;
import com.fatema.jwtSecurity.repository.ITokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class JwtService {
    private final ITokenRepository tokenRepository;

    private final String SECREATKEY="b00aea8eefbb4e59fcbb33082b1cf1607daa1ab0431fadbb05a70ed10f0eea20";

    //Extracts username from JWT token
    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }

    // Extracts expiration date from the token
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // Checks if the token is expired
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    // Validate whether the token is valid for a given user
    public boolean isValid(String token, UserDetails user){
        String username = extractUserName(token);

        //Check if the token id valid and not expired
        boolean validToken = tokenRepository
                                .findByToken(token)
                                .map(token1 -> !token1.isLoggedOut())
                                .orElse(false);
        return (username.equals(user.getUsername())) && !isTokenExpired(token) && validToken;


    }
    //Extracts a specific claim form the token's claims
    public <T> T extractClaim(String token, Function<Claims,T> resolver){
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }
    // Parses and verifies the token to extract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

//______________________________________________ Token Create --------------------------------------------

    // Method signature indicating that this method generates a token for a given user
    public String generateToken(User user){
        String token = Jwts
                .builder()
                //Setting the subject of the token to the user's email address.
                .subject(user.getEmail())
                // Setting the timestamp when the token was issued to the current time.
                .issuedAt(new Date(System.currentTimeMillis()))
                //Setting the expiration time of the token to 24 hours from the current time.
                .expiration(new Date(System.currentTimeMillis()+
                        24 * 60 *60 * 1000))
               //Signing the token with a signing key obtained form a mentod called getSignKey
                .signWith(getSignKey())
                //Compacting the token into its final string representation
                .compact();
        return token;
         }
    // Retrieves the signing key used for JWT signing and verification
    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECREATKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
