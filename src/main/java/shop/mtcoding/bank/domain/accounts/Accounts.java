package shop.mtcoding.bank.domain.accounts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.mtcoding.bank.domain.users.Users;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor // 빈등록시 기본생성자 필요함
@EntityListeners(AuditingEntityListener.class) // @CreatedDate, @LastModifiedDate 작동시키기 위해 필요함
@Table(name = "accounts")
@Entity
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 20)
    private Integer number;

    @Column(nullable = false, length = 4)
    private Integer password;

    @Column(nullable = false)
    private long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @CreatedDate
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Accounts(long id, Integer number, Integer password, long balance, Users user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.password = password;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
