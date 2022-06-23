package dankook.play.studentcouncilhomepage.domain.user.exception;

public class NotExistException extends IllegalArgumentException {

    public NotExistException() {
        super();
    }

    public NotExistException(String message) {
        super(message);
    }
}
