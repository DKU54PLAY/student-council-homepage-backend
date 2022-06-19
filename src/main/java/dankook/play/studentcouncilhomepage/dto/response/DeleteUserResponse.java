package dankook.play.studentcouncilhomepage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeleteUserResponse {
    private boolean status;

    public DeleteUserResponse(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}