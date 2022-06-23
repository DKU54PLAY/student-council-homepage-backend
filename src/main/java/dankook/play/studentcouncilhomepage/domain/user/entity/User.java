package dankook.play.studentcouncilhomepage.domain.user.entity;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

import dankook.play.studentcouncilhomepage.domain.user.entity.enumulation.Department;

import javax.persistence.Column;
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

    private String userName;

    private String phoneNumber;

    private String email;

    private Password password;

    @Enumerated(STRING)
    private Department department;

    private String imageUrl;

    public User(String email, String password, String userName, String phoneNumber, String department,
                String imageUrl) {
        this.email = email;
        this.password = new Password(password);
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.department = Department.of(department);
        this.imageUrl = imageUrl;
    }

    public void checkCorrectPassword(String targetPassword) {
        password.checkSamePassword(targetPassword);
    }
}
