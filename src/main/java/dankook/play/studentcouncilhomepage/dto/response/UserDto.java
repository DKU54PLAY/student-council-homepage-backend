package dankook.play.studentcouncilhomepage.dto.response;

import dankook.play.studentcouncilhomepage.domain.User;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private Department department;
    private String imageUrl;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.department = user.getDepartment();
        this.imageUrl = user.getImageUrl();
    }
}