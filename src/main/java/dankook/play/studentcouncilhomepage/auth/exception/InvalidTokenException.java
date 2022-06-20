package dankook.play.studentcouncilhomepage.auth.exception;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(final String message) {
        super(message);
    }
}
