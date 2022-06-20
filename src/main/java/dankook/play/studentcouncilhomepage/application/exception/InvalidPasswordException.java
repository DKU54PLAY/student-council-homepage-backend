package dankook.play.studentcouncilhomepage.application.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(final String message) {
        super(message);
    }
}
