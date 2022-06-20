package dankook.play.studentcouncilhomepage.service;

import com.sun.jdi.request.DuplicateRequestException;
import dankook.play.studentcouncilhomepage.domain.User;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import dankook.play.studentcouncilhomepage.dto.request.DeleteUserRequest;
import dankook.play.studentcouncilhomepage.dto.request.SignUpRequest;
import dankook.play.studentcouncilhomepage.dto.request.UpdateUserRequest;
import dankook.play.studentcouncilhomepage.dto.response.DeleteUserResponse;
import dankook.play.studentcouncilhomepage.dto.response.SignUpResponse;
import dankook.play.studentcouncilhomepage.dto.response.UpdateUserResponse;
import dankook.play.studentcouncilhomepage.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = signUpRequest.toUserEnitiy();
        userRepository.save(user);
        return new SignUpResponse(user.getId());
    }

    @Transactional
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(NoSuchElementException::new);
        boolean status = checkPassword(user.getPassword(), request.getPassword());
        updateUser(user, request.getPhoneNumber(), request.getDepartment(), request.getImageUrl(), status);
        user = findOne(request.getId());
        return new UpdateUserResponse(user);
    }

    private void updateUser(User user, String phoneNumber, Department department, String imageUrl, boolean status) {
        if(status) {
            user.userUpdate(phoneNumber, department, imageUrl);
        }
        // TODO : 비밀번호가 다를 경우 Response
    }

    @Transactional
    public DeleteUserResponse delete(DeleteUserRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(NoSuchElementException::new);
        boolean status = checkPassword(user.getPassword(), request.getPassword());
        deleteUser(user, status);
        return new DeleteUserResponse(status);
    }

    private void deleteUser(User user, boolean status) {
        if(status) {
            userRepository.delete((user));
        }
        // TODO : 비밀번호가 다를 경우 Response
    }

    public boolean checkPassword(String originPassword, String comparePassword) {
        return originPassword.equals(comparePassword);
    }

}
