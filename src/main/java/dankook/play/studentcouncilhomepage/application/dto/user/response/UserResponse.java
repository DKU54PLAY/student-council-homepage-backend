package dankook.play.studentcouncilhomepage.application.dto.user.response;

import dankook.play.studentcouncilhomepage.application.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private String username;

    private String phoneNumber;

    private String email;

    private String department;

    private String imageUrl;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.department = user.getDepartment().getName();
        this.imageUrl = user.getImageUrl();
    }
}
