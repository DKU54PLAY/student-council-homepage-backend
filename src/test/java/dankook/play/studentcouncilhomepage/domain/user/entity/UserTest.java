package dankook.play.studentcouncilhomepage.domain.user.entity;

import static dankook.play.studentcouncilhomepage.domain.user.entity.enumulation.Department.TEST;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dankook.play.studentcouncilhomepage.domain.user.entity.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("비밀번호 일치 여부를 확인할 수 있다.")
    @Test
    void checkCorrectPassword() {
        // given
        final Password password = new Password("testtest1!");
        final User user = new User(1L, "test@email.com", "010-1234-5678", "testName", password, TEST, "testImageUrl");

        // when & then
        assertThatThrownBy(() -> user.checkCorrectPassword("wrongtesttest1!"));
    }
}
