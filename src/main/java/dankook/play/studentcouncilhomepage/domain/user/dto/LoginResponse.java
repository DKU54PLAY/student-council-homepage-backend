package dankook.play.studentcouncilhomepage.domain.user.dto;

import dankook.play.studentcouncilhomepage.domain.user.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginResponse {

    private final Long id;
    private final String email;
    private final String userName;
    private final String imageUrl;
    private final String token;

    public LoginResponse(User user, String token) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.imageUrl = user.getImageUrl();
        this.token = token;
    }
}
