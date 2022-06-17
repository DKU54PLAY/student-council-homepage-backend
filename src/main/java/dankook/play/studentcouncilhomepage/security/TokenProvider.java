package dankook.play.studentcouncilhomepage.security;

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
            Jwts.parser().setSigningKey(secretKey.getJwtSecretKey()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.info("유효하지 않은 JWT signature 입니다");
        } catch (ExpiredJwtException e) {
            log.info("유효기간이 지난 JWT 토큰 입니다");
        } catch (MalformedJwtException | IllegalArgumentException e) {
            log.info("유효하지 않은 JWT 토큰 입니다");
        } catch (UnsupportedJwtException e) {
            log.info("지원하지 않는 JWT 토큰 입니다");
        }
        return false;
    }

    public String extractUserEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getJwtSecretKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
