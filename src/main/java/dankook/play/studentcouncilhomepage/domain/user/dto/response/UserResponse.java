package dankook.play.studentcouncilhomepage.domain.user.dto.response;

import dankook.play.studentcouncilhomepage.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private String userName;

    private String phoneNumber;

    private String email;

    private String department;

    private String imageUrl;

    public UserResponse(User user) {
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.department = user.getDepartment().getName();
        this.imageUrl = user.getImageUrl();
    }
}
