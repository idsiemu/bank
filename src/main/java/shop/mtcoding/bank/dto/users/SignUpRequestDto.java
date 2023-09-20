package shop.mtcoding.bank.dto.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.users.UserEnum;
import shop.mtcoding.bank.domain.users.Users;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpRequestDto {
    @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$", message = "영문/숫자 2~20자로 해주세여")
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{2,20}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 작성해주세요.")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z가-힣]{1,20}$", message = "한글/영문 1~20자로 해주세여")
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
