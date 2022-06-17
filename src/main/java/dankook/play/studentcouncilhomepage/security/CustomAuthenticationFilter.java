package dankook.play.studentcouncilhomepage.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import dankook.play.studentcouncilhomepage.domain.user.UserExceptionSet;
import dankook.play.studentcouncilhomepage.domain.user.dto.LoginRequest;
import dankook.play.studentcouncilhomepage.exception.ApplicationException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("올바르지 않은 인증 method 입니다." + request.getMethod());
        }

        LoginRequest loginRequest;

        try {
            loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
        } catch (IOException e) {
            throw new ApplicationException(UserExceptionSet.BAD_LOGIN);
        }

        String userEmail = loginRequest.getEmail();
        String userPassword = loginRequest.getPassword();

        if (userEmail == null) {
            userEmail = "";
        }

        if (userPassword == null) {
            userPassword = "";
        }
        userEmail = userEmail.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                userEmail, userPassword);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
