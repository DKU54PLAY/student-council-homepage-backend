package dankook.play.studentcouncilhomepage.domain.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {

    private static final String INVALID_EMAIL = "잘못된 이메일 형식입니다.";
    private static final String INVALID_PASSWORD = "잘못된 비밀번호 형식입니다.";
    private static final String INVALID_USERNAME = "잘못된 이름 입력입니다.";

    @NotBlank(message = INVALID_EMAIL)
    @Email(message = INVALID_EMAIL, regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

    @NotBlank(message = INVALID_PASSWORD)
    @Pattern(message = INVALID_PASSWORD, regexp = "^.*(?=^.{8,12}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
    private String password;

    @NotBlank(message = INVALID_USERNAME)
    @Size(message = INVALID_USERNAME, max = 10)
    private String userName;

    private String phoneNumber;

    private String department;

    private String imageUrl;

    private UserRequest() {
    }
}
