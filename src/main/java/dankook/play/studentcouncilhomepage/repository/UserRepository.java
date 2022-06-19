package dankook.play.studentcouncilhomepage.repository;

import dankook.play.studentcouncilhomepage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);
    void delete(User user);
}
