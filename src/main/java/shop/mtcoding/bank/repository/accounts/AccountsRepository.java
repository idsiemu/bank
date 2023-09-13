package shop.mtcoding.bank.repository.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.bank.domain.accounts.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
