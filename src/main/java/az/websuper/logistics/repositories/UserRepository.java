package az.websuper.logistics.repositories;

import az.websuper.logistics.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
