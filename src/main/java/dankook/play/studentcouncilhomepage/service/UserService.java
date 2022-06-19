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

//    public List<User> findUsers() {
//        return userRepository.findAll();
//    }

    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = signUpRequest.toUserEnity();
        userRepository.save(user);
        return new SignUpResponse(user.getId());
    }

    @Transactional
    public UpdateUserResponse update(UpdateUserRequest request) {
        updateUser(request.getId(), request.getPhoneNumber(), request.getDepartment(), request.getImageUrl());
        User user = findOne(request.getId());
        return new UpdateUserResponse(user.getPhoneNumber(), request.getDepartment(), request.getImageUrl());
    }


    private void updateUser(Long id, String phoneNumber, Department department, String imageUrl) {
        final User user = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        user.updateUser(phoneNumber, department, imageUrl);
    }

    @Transactional
    public DeleteUserResponse deleteUser(DeleteUserRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(NoSuchElementException::new);
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse(checkPassword(user.getPassword(), request.getPassword()));
        if(deleteUserResponse.getStatus()) {
            userRepository.delete(user);
        }
        return deleteUserResponse;
    }

    public static boolean checkPassword(String originPassword, String comparePassword) {
        System.out.println(originPassword + "<>" + comparePassword);
        return originPassword.equals(comparePassword);
    }

}