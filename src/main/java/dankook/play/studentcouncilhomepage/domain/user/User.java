package dankook.play.studentcouncilhomepage.domain.user;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

import dankook.play.studentcouncilhomepage.domain.BaseEntity;
import dankook.play.studentcouncilhomepage.domain.enumulation.Department;
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

    private String password;

    @Enumerated(STRING)
    private Department department;

    private String imageUrl;

}
