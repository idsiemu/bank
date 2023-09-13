package shop.mtcoding.bank.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.bank.domain.users.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
