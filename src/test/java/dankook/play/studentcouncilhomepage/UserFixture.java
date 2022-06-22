package dankook.play.studentcouncilhomepage;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.domain.vo.Password;
import dankook.play.studentcouncilhomepage.application.dto.user.request.UserRequest;

public class UserFixture {

    public static final Password SAMPLE_PASSWORD = new Password("password1!");
    public static final User SAMPLE_USER = new User("email@email.com", "password1!", "username",
            "010-1111-1111", "컴퓨터공학과", "imageUrl");
    public static final UserRequest USER_REQUEST = new UserRequest("email@email.com", "password1!",
            "username", "010-1111-1111", "컴퓨터공학과", "imageUrl");

    private UserFixture() {
    }
}
