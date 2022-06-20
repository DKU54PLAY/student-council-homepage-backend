package dankook.play.studentcouncilhomepage.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

    private static final String INVALID_EMAIL = "Invalid Email";

    @NotBlank(message = INVALID_EMAIL)
    @Email(message = INVALID_EMAIL, regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

    private String password;
}
