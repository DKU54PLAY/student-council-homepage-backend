package dankook.play.studentcouncilhomepage.application.domain.vo;

import static lombok.AccessLevel.PROTECTED;

import dankook.play.studentcouncilhomepage.application.exception.InvalidPasswordException;
import java.util.regex.Pattern;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = PROTECTED)
public class Password {

    private static final String REGEX = "^.*(?=^.{8,12}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";

    private String password;

    public Password(String password) {
        validate(password);
        this.password = password;
    }

    private static void validate(String password) {
        checkSize(password);
        checkArgument(Pattern.matches(REGEX, password));
    }

    private static void checkSize(String password) {
        if (password.isBlank() || password.length() < 8 || password.length() > 12) {
            throw new IllegalArgumentException("Invalid Password");
        }
    }

    private static void checkArgument(boolean matches) {
        if (!matches) {
            throw new IllegalArgumentException("Invalid Password");
        }
    }

    public void checkSamePassword(String password) {
        if (!this.password.equals(password)) {
            throw new InvalidPasswordException("Incorrect Password");
        }
    }
}
