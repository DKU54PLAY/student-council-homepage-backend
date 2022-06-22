package dankook.play.studentcouncilhomepage.application.dto.user.response;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private String username;

    private String phoneNumber;

    private String email;

    private Department department;

    private String imageUrl;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.department = user.getDepartment();
        this.imageUrl = user.getImageUrl();
    }
}
