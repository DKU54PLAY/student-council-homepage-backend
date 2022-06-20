package dankook.play.studentcouncilhomepage.dto.response;

import dankook.play.studentcouncilhomepage.domain.User;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateUserResponse {
    private String userName;
    private String phoneNumber;
    private String email;
    private Department department;
    private String imageUrl;

    public UpdateUserResponse (User user) {
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.department = user.getDepartment();
        this.imageUrl = user.getImageUrl();
    }
}
