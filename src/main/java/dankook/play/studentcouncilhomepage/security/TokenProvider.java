package dankook.play.studentcouncilhomepage.security;

import dankook.play.studentcouncilhomepage.exception.ApplicationException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenProvider {
    private final SecretKey secretKey;

    public String createToken(Authentication authentication) {
        UserAuthPrinciple userAuthPrinciple = (UserAuthPrinciple) authentication.getPrincipal();

        Date expireAt = new Date();
        expireAt.setTime(expireAt.getTime() + secretKey.getJwtValidTime());

        return Jwts.builder()
                .setSubject(userAuthPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS512, secretKey.getJwtSecretKey())
                .compact();
    }

    public boolean validateToken(String authToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey.getJwtSecretKey()).parseClaimsJws(authToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new ApplicationException(AuthExceptionSet.INVALID_TOKEN);
        }
    }

    public String extractUserEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getJwtSecretKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
