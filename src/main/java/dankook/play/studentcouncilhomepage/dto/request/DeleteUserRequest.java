package dankook.play.studentcouncilhomepage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class DeleteUserRequest {
    private Long id;
    private String password;
}
