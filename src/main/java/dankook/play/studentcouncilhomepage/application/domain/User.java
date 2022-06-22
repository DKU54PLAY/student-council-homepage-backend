package dankook.play.studentcouncilhomepage.application.domain;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

import dankook.play.studentcouncilhomepage.application.domain.enumulation.Department;
import dankook.play.studentcouncilhomepage.application.domain.vo.Password;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String email;

    @Embedded
    private Password password;

    private String username;

    private String phoneNumber;

    @Enumerated(STRING)
    private Department department;

    private String imageUrl;

    public User(String email, Password password, String username, String phoneNumber, Department department,
                String imageUrl) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.imageUrl = imageUrl;
    }

    public void checkCorrectPassword(String targetPassword) {
        password.checkSamePassword(targetPassword);
    }
}
