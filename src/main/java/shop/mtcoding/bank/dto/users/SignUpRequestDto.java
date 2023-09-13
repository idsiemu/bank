package shop.mtcoding.bank.dto.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.users.UserEnum;
import shop.mtcoding.bank.domain.users.Users;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SignUpRequestDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String fullname;

    public Users toEntity(BCryptPasswordEncoder passwordEncoder) {
        return Users.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .fullname(fullname)
                .role(UserEnum.CUSTOMER)
                .build();
    }
}
