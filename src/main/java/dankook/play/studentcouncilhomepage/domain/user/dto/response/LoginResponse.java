package dankook.play.studentcouncilhomepage.domain.user.dto.response;

import dankook.play.studentcouncilhomepage.domain.user.entity.User;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private Long id;
    private String email;
    private String userName;
    private String imageUrl;
    private String token;

    public LoginResponse(User user, String token) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.imageUrl = user.getImageUrl();
        this.token = token;
    }
}
