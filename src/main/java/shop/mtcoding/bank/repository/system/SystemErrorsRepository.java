package shop.mtcoding.bank.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.bank.domain.system.SystemErrors;

public interface SystemErrorsRepository extends JpaRepository<SystemErrors, String> {
}
