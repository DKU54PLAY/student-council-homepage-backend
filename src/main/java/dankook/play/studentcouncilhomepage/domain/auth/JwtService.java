package dankook.play.studentcouncilhomepage.domain.auth;

import dankook.play.studentcouncilhomepage.domain.user.entity.User;
import dankook.play.studentcouncilhomepage.domain.user.exception.NotExistException;
import dankook.play.studentcouncilhomepage.domain.user.repository.UserRepository;
import dankook.play.studentcouncilhomepage.domain.user.dto.response.LoginResponse;
import dankook.play.studentcouncilhomepage.domain.user.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;

    public LoginResponse createToken(LoginRequest loginRequest) {
        String token = tokenProvider.createToken(loginRequest.getEmail());
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(NotExistException::new);
        return new LoginResponse(user, token);
    }

    public String findUserEmailByToken(String token) {
        return tokenProvider.extractEmailFromToken(token);
    }
}
