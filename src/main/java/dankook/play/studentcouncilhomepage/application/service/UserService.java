package dankook.play.studentcouncilhomepage.application.service;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.dto.user.response.UserResponse;
import dankook.play.studentcouncilhomepage.application.exception.NotExistException;
import dankook.play.studentcouncilhomepage.application.repository.UserRepository;
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
    public Long save(User user) {
        final User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
