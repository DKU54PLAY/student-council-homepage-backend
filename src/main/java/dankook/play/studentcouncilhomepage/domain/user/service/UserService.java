package dankook.play.studentcouncilhomepage.domain.user.service;

import dankook.play.studentcouncilhomepage.domain.user.entity.User;
import dankook.play.studentcouncilhomepage.domain.user.repository.UserRepository;
import dankook.play.studentcouncilhomepage.domain.user.exception.NotExistException;
import dankook.play.studentcouncilhomepage.domain.user.dto.request.UserRequest;
import dankook.play.studentcouncilhomepage.domain.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse findByEmail(String email) {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(NotExistException::new);

        return new UserResponse(user);
    }

    public UserResponse findById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(NotExistException::new);

        return new UserResponse(user);
    }

    @Transactional
    public Long save(UserRequest request) {
        final User user = userFromRequest(request);
        final User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    private User userFromRequest(UserRequest request) {
        return new User(request.getEmail(), request.getPassword(), request.getUserName(),
                request.getPhoneNumber(), request.getDepartment(), request.getImageUrl());
    }
}
