package dankook.play.studentcouncilhomepage.dto.request;

import dankook.play.studentcouncilhomepage.domain.User;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SignUpRequest {
    private Long id;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private Department department;
    private String imageUrl;

    public User toUserEnitiy() {
        return new User(this.id, this.userName, this.phoneNumber, this.email, this.password, this.department, this.imageUrl);
    }
}
