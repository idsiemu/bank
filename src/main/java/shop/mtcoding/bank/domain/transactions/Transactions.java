package shop.mtcoding.bank.domain.transactions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.mtcoding.bank.domain.accounts.Accounts;
import shop.mtcoding.bank.domain.users.Users;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor // 빈등록시 기본생성자 필요함
@EntityListeners(AuditingEntityListener.class) // @CreatedDate, @LastModifiedDate 작동시키기 위해 필요함
@Table(name = "transactions")
@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "withdraw_account_id")
    private Accounts withdrawAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_account_id")
    private Accounts depositAccount;

    @Column(nullable = false)
    private long amount;

    private long withdrawAccountBalance;
    private long depositAccountBalance;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionTypes type;

    private String sender;
    private String receiver;
    private String tel;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder

    public Transactions(long id, Accounts withdrawAccount, Accounts depositAccount, long amount, long withdrawAccountBalance, long depositAccountBalance, TransactionTypes type, String sender, String receiver, String tel, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.withdrawAccount = withdrawAccount;
        this.depositAccount = depositAccount;
        this.amount = amount;
        this.withdrawAccountBalance = withdrawAccountBalance;
        this.depositAccountBalance = depositAccountBalance;
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.tel = tel;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
