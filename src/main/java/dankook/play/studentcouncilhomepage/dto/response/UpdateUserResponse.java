package dankook.play.studentcouncilhomepage.dto.response;

import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
public class UpdateUserResponse {
    private String phoneNumber;
    private Department department;
    private String imageUrl;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public UpdateUserResponse(String phoneNumber, Department department, String imageUrl) {
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.imageUrl = imageUrl;
    }

}
