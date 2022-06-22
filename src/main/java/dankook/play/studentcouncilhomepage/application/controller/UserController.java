package dankook.play.studentcouncilhomepage.application.controller;

import dankook.play.studentcouncilhomepage.application.dto.user.request.UserRequest;
import dankook.play.studentcouncilhomepage.application.dto.user.response.UserResponse;
import dankook.play.studentcouncilhomepage.application.service.UserService;
import dankook.play.studentcouncilhomepage.auth.supports.AuthenticationPrincipal;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UserRequest request) {
        userService.save(request);

        return ResponseEntity.created(URI.create("/login")).build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> findUserByEmail(@AuthenticationPrincipal String email) {
        final UserResponse response = userService.findByEmail(email);

        return ResponseEntity.ok(response);
    }
}
