package dankook.play.studentcouncilhomepage.application.acceptance;

import static dankook.play.studentcouncilhomepage.UserFixture.USER_REQUEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import dankook.play.studentcouncilhomepage.application.dto.user.response.UserResponse;
import dankook.play.studentcouncilhomepage.auth.dto.TokenRequest;
import dankook.play.studentcouncilhomepage.auth.dto.TokenResponse;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserAcceptanceTest extends AcceptanceTest {

    private static final String BEARER = "Bearer ";

    @DisplayName("email, password 등 유저 정보를 가지고회원가입을 요청하면 해당 정보로 고객 정보를 생성한다.")
    @Test
    public void register() {
        // given & when
        final ExtractableResponse<Response> response = AcceptanceFixture.post(USER_REQUEST, "/api/users");

        // then
        assertThat(response.statusCode()).isEqualTo(CREATED.value());
        assertThat(response.header("Location")).isNotBlank().isEqualTo("/login");
    }

    @DisplayName("회원가입 이후에 회원가입시에 사용한 email과 password로 로그인할 수 있다.")
    @Test
    public void login() {
        // given
        AcceptanceFixture.post(USER_REQUEST, "/api/users");

        // when
        final TokenRequest tokenRequest = new TokenRequest(USER_REQUEST.getEmail(), USER_REQUEST.getPassword());
        final ExtractableResponse<Response> loginResponse =
                AcceptanceFixture.post(tokenRequest, "/api/auth/login");

        // then
        assertThat(loginResponse.statusCode()).isEqualTo(OK.value());

        final String accessToken = extractAccessToken(loginResponse);
        final ExtractableResponse<Response> response =
                AcceptanceFixture.get("/api/users/me", createHeader(accessToken));
        final UserResponse userResponse = extractUser(response);
        assertThat(userResponse).extracting("email", "username")
                .contains(USER_REQUEST.getEmail(), USER_REQUEST.getUsername());
    }

    private String extractAccessToken(ExtractableResponse<Response> response) {
        return response.jsonPath()
                .getObject(".", TokenResponse.class)
                .getAccessToken();
    }

    private Header createHeader(String accessToken) {
        return new Header("Authorization", BEARER + accessToken);
    }

    private UserResponse extractUser(ExtractableResponse<Response> response) {
        return response.jsonPath()
                .getObject(".", UserResponse.class);
    }
}
