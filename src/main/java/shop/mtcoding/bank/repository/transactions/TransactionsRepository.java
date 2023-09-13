package shop.mtcoding.bank.repository.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.bank.domain.transactions.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
