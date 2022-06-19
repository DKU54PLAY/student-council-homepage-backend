package dankook.play.studentcouncilhomepage.dto.request;

import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateUserRequest {
    private Long id;
    private String phoneNumber;
    private Department department;
    private String imageUrl;
}