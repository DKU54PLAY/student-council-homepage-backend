package dankook.play.studentcouncilhomepage.domain.auth.infra;

import dankook.play.studentcouncilhomepage.domain.auth.AuthorizationExtractor;
import dankook.play.studentcouncilhomepage.domain.auth.TokenProvider;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class UserInterceptor extends AbstractInterceptor {

    private final TokenProvider tokenProvider;

    @Override
    boolean process(HttpServletRequest request) {
        String token = AuthorizationExtractor.extract(request);
        return tokenProvider.validateToken(token);
    }
}
