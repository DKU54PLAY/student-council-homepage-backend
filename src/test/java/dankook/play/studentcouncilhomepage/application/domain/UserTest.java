package dankook.play.studentcouncilhomepage.application.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dankook.play.studentcouncilhomepage.application.domain.enumulation.Department;
import dankook.play.studentcouncilhomepage.application.domain.vo.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("비밀번호 일치 여부를 확인할 수 있다.")
    @Test
    public void checkCorrectPassword() {
        // given
        final Password password = new Password("password1!");
        final User user = new User(1L, "010-2966-1498", "email@email.com",
                password, Department.COMPUTER_ENGINEERING, "imageUrl");

        // when & then
        assertThatThrownBy(() -> user.checkCorrectPassword("incorrectPassword1!"));
    }
}
