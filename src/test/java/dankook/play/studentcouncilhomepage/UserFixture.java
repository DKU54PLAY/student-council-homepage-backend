package dankook.play.studentcouncilhomepage;

import static dankook.play.studentcouncilhomepage.application.domain.enumulation.Department.COMPUTER_ENGINEERING;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.domain.vo.Password;

public class UserFixture {

    public static final Password SAMPLE_PASSWORD = new Password("password1!");
    public static final User SAMPLE_USER = new User("email@email.com", SAMPLE_PASSWORD, "username",
            "010-1111-1111", COMPUTER_ENGINEERING, "imageUrl");

    private UserFixture() {
    }
}
