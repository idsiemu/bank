package shop.mtcoding.bank.dummy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.users.UserEnum;
import shop.mtcoding.bank.domain.users.Users;

import java.time.LocalDateTime;

public class DummyData {
    protected Users newUser(String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return Users.builder()
                .email("asdf@gmail.com")
                .role(UserEnum.CUSTOMER)
                .fullname("asdf")
                .password(passwordEncoder.encode("asdf"))
                .username(username)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    protected Users newMockUser(long id, String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return Users.builder()
                .id(id)
                .email("asdf@gmail.com")
                .role(UserEnum.CUSTOMER)
                .fullname("asdf")
                .password(passwordEncoder.encode("asdf"))
                .username(username)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
