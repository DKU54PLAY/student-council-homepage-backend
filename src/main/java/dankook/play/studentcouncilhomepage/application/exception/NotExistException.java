package dankook.play.studentcouncilhomepage.application.exception;

public class NotExistException extends IllegalArgumentException {

    public NotExistException() {
        super();
    }

    public NotExistException(String message) {
        super(message);
    }
}
