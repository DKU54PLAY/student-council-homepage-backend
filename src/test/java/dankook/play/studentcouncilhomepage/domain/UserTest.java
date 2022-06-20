package dankook.play.studentcouncilhomepage.domain;

import dankook.play.studentcouncilhomepage.controller.UserController;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dankook.play.studentcouncilhomepage.domain.enumulation.Department.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("User가 phoneNumber, department, imageUrl 중에 입력한 값 만 변경된다.")
    @Test
    void userUpdate() {
        User user = null;
        assertDoesNotThrow(() -> user.userUpdate("010-Test-010", TEST, "image/test"));
    }
}