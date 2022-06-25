package dankook.play.studentcouncilhomepage;

import dankook.play.studentcouncilhomepage.domain.user.entity.User;
import dankook.play.studentcouncilhomepage.domain.user.entity.Password;
import dankook.play.studentcouncilhomepage.domain.user.dto.request.UserRequest;

public class UserFixture {

    public static final Password SAMPLE_PASSWORD = new Password("testtest1!");
    public static final User SAMPLE_USER = new User("test@email.com", "testtest1!", "testName",
            "010-1234-5678", "테스트", "testImageUrl");
    public static final UserRequest USER_REQUEST = new UserRequest("test@email.com", "testtest1!",
            "testName", "010-1234-5678", "테스트", "testImageUrl");

    private UserFixture() {
    }
}
