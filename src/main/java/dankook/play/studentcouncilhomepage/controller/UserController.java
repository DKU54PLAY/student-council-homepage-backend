package dankook.play.studentcouncilhomepage.controller;

import dankook.play.studentcouncilhomepage.dto.request.SignUpRequest;
import dankook.play.studentcouncilhomepage.dto.response.DeleteUserResponse;
import dankook.play.studentcouncilhomepage.dto.response.SignUpResponse;
import dankook.play.studentcouncilhomepage.dto.response.UpdateUserResponse;
import dankook.play.studentcouncilhomepage.dto.response.UserDto;
import dankook.play.studentcouncilhomepage.dto.request.UpdateUserRequest;
import dankook.play.studentcouncilhomepage.dto.request.DeleteUserRequest;
import dankook.play.studentcouncilhomepage.service.UserService;
import dankook.play.studentcouncilhomepage.domain.User;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(userService.signUp(signUpRequest));
    }

    @GetMapping("/{userIdx}")
    public ResponseEntity<UserDto> findById(@PathVariable("userIdx") Long userIdx) {
        User user = userService.findOne(userIdx);
        UserDto userDto = new UserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/update")
    public ResponseEntity<UpdateUserResponse> updateUser(@Valid @RequestBody UpdateUserRequest request) {
        UpdateUserResponse response = userService.update(request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserResponse> deleteUser(@Valid @RequestBody DeleteUserRequest request) {
        DeleteUserResponse response = userService.deleteUser(request);
        return ResponseEntity.ok(response);
    }
}
