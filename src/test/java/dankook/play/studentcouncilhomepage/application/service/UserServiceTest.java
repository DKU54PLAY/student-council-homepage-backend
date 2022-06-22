package dankook.play.studentcouncilhomepage.application.service;

import static dankook.play.studentcouncilhomepage.UserFixture.SAMPLE_USER;
import static org.assertj.core.api.Assertions.assertThat;

import dankook.play.studentcouncilhomepage.application.domain.User;
import dankook.play.studentcouncilhomepage.application.dto.user.response.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    private final UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @DisplayName("email 을 통해서 회원 정보를 조회할 수 있다.")
    @Test
    public void findByEmail() {
        // given
        final User user = SAMPLE_USER;
        userService.save(user);

        // when
        final UserResponse userResponse = userService.findByEmail(user.getEmail());

        // then
        assertThat(user)
                .extracting("email", "username", "phoneNumber", "department", "imageUrl")
                .contains(userResponse.getEmail(), userResponse.getUsername(), userResponse.getPhoneNumber(),
                        userResponse.getDepartment(), userResponse.getImageUrl());
    }

    @DisplayName("id 값을 통해서 회원 정보를 조회할 수 있다.")
    @Test
    public void findById() {
        // given
        final User user = SAMPLE_USER;
        final Long savedId = userService.save(user);

        // when
        final UserResponse userResponse = userService.findById(savedId);

        // then
        assertThat(user)
                .extracting("email", "username", "phoneNumber", "department", "imageUrl")
                .contains(userResponse.getEmail(), userResponse.getUsername(), userResponse.getPhoneNumber(),
                        userResponse.getDepartment(), userResponse.getImageUrl());
    }

    @DisplayName("회원 정보를 저장할 수 있다.")
    @Test
    public void save() {
        // given & when
        final Long savedId = userService.save(SAMPLE_USER);

        // then
        final UserResponse userResponse = userService.findById(savedId);
        assertThat(userResponse).isNotNull();
    }
}
