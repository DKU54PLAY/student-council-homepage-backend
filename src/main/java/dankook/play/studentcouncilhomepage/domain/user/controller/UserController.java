package dankook.play.studentcouncilhomepage.domain.user.controller;

import dankook.play.studentcouncilhomepage.domain.user.dto.request.LoginRequest;
import dankook.play.studentcouncilhomepage.domain.user.dto.response.LoginResponse;
import dankook.play.studentcouncilhomepage.domain.user.service.UserService;
import dankook.play.studentcouncilhomepage.domain.user.dto.request.UserRequest;
import dankook.play.studentcouncilhomepage.domain.user.dto.response.UserResponse;
import dankook.play.studentcouncilhomepage.domain.auth.JwtAuth;
import dankook.play.studentcouncilhomepage.domain.auth.JwtService;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UserRequest request) {
        userService.save(request);

        return ResponseEntity.created(URI.create("/login")).build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> findUserByEmail(@JwtAuth String email) {
        final UserResponse response = userService.findByEmail(email);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        final LoginResponse token = jwtService.createToken(request);

        return ResponseEntity.status(HttpStatus.OK).location(URI.create("/")).body(token);
    }
}
