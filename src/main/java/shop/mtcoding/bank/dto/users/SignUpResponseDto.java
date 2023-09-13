package shop.mtcoding.bank.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.bank.domain.users.Users;

@Getter
@Setter
@ToString
public class SignUpResponseDto {
    private long id;
    private String username;
    private String email;
    private String fullname;

    public SignUpResponseDto(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.fullname = user.getFullname();
    }
}
