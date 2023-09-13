package shop.mtcoding.bank.domain.system;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_errors")
@Entity
public class SystemErrors {

    @Id
    @Column(name = "code", unique = true, nullable = false, length = 7)
    private String code;

    @Column(nullable = false)
    private String message;

    @CreatedDate
    @Column(nullable = false, name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Builder
    public SystemErrors(String code, String message, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code = code;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
