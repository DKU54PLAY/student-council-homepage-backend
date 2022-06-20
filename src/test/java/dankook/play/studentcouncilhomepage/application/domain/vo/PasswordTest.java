package dankook.play.studentcouncilhomepage.application.domain.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordTest {

    @DisplayName("비밀번호는 형식을 지켜야한다.")
    @Test
    public void checkPassword() {
        assertThatThrownBy(() -> new Password("pwd1!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비밀번호는 형식을 지키면 제대로 생성된다.")
    @Test
    public void createPassword() {
        assertDoesNotThrow(() -> new Password("password1!"));
    }
}
