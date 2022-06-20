package dankook.play.studentcouncilhomepage.application.repository;

import dankook.play.studentcouncilhomepage.application.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
