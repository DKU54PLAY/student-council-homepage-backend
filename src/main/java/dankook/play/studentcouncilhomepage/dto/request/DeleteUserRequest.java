package dankook.play.studentcouncilhomepage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
public class DeleteUserRequest {
    private Long id;
    private String password;

    public DeleteUserRequest(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
