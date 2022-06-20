package dankook.play.studentcouncilhomepage.auth.service;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.exception.InvalidPasswordException;
import dankook.play.studentcouncilhomepage.application.exception.NotExistException;
import dankook.play.studentcouncilhomepage.application.repository.UserRepository;
import dankook.play.studentcouncilhomepage.auth.dto.TokenRequest;
import dankook.play.studentcouncilhomepage.auth.dto.TokenResponse;
import dankook.play.studentcouncilhomepage.auth.exception.InvalidLoginException;
import dankook.play.studentcouncilhomepage.auth.exception.InvalidTokenException;
import dankook.play.studentcouncilhomepage.auth.supports.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public TokenResponse createToken(TokenRequest request) {
        try {
            checkUser(request);
        } catch (NotExistException | InvalidPasswordException e) {
            throw new InvalidLoginException("Login Fail");
        }

        final String token = jwtTokenProvider.createToken(request.getEmail());
        return new TokenResponse(token);
    }

    private void checkUser(TokenRequest request) {
        final User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(NotExistException::new);

        user.checkCorrectPassword(request.getPassword());
    }

    public String findUserByToken(String token) {
        if (jwtTokenProvider.validateToken(token)) {
            return jwtTokenProvider.getPayload(token);
        }
        throw new InvalidTokenException("Invalid Token");
    }
}
