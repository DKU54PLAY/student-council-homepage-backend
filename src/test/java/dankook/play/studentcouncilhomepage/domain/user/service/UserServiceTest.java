package dankook.play.studentcouncilhomepage.domain.user.service;

import static dankook.play.studentcouncilhomepage.UserFixture.USER_REQUEST;
import static org.assertj.core.api.Assertions.assertThat;

import dankook.play.studentcouncilhomepage.domain.user.dto.request.UserRequest;
import dankook.play.studentcouncilhomepage.domain.user.dto.response.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql("/truncate.sql")
class UserServiceTest {

    private final UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @DisplayName("email 을 통해서 회원 정보를 조회할 수 있다.")
    @Test
    void findByEmail() {
        // given
        final UserRequest request = USER_REQUEST;
        final Long savedId = userService.save(request);

        // when
        final UserResponse userResponse = userService.findByEmail(request.getEmail());

        // then
        assertThat(request)
                .extracting("email", "userName", "phoneNumber", "department", "imageUrl")
                .contains(userResponse.getEmail(), userResponse.getUserName(), userResponse.getPhoneNumber(),
                        userResponse.getDepartment(), userResponse.getImageUrl());
    }

    @DisplayName("id 값을 통해서 회원 정보를 조회할 수 있다.")
    @Test
    void findById() {
        // given
        final Long savedId = userService.save(USER_REQUEST);

        // when
        final UserResponse userResponse = userService.findById(savedId);

        // then
        assertThat(USER_REQUEST)
                .extracting("email", "userName", "phoneNumber", "department", "imageUrl")
                .contains(userResponse.getEmail(), userResponse.getUserName(), userResponse.getPhoneNumber(),
                        userResponse.getDepartment(), userResponse.getImageUrl());
    }

    @DisplayName("회원 정보를 저장할 수 있다.")
    @Test
    void save() {
        // given & when
        final Long savedId = userService.save(USER_REQUEST);

        // then
        final UserResponse userResponse = userService.findById(savedId);
        assertThat(userResponse).isNotNull();
    }
}
