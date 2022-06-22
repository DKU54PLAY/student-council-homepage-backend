package dankook.play.studentcouncilhomepage.auth.controller;

import static org.springframework.http.HttpStatus.OK;

import dankook.play.studentcouncilhomepage.auth.dto.TokenRequest;
import dankook.play.studentcouncilhomepage.auth.dto.TokenResponse;
import dankook.play.studentcouncilhomepage.auth.service.AuthService;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody TokenRequest request) {
        final TokenResponse token = authService.createToken(request);

        return ResponseEntity.status(OK).location(URI.create("/")).body(token);
    }
}
