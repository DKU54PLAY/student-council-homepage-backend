package dankook.play.studentcouncilhomepage.domain.user.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(final String message) {
        super(message);
    }
}
