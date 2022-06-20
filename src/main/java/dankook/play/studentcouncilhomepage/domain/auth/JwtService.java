package dankook.play.studentcouncilhomepage.domain.auth;

import dankook.play.studentcouncilhomepage.domain.user.User;
import dankook.play.studentcouncilhomepage.domain.user.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final TokenProvider tokenProvider;

    public LoginResponse createToken(User user) {
        String token = tokenProvider.createToken(user.getEmail());
        return new LoginResponse(user, token);
    }

    public String findUserEmailByToken(String token) {
        return tokenProvider.extractEmailFromToken(token);
    }
}
