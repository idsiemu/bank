package shop.mtcoding.bank.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.system.SystemErrors;
import shop.mtcoding.bank.domain.users.UserEnum;
import shop.mtcoding.bank.domain.users.Users;
import shop.mtcoding.bank.repository.system.SystemErrorsRepository;
import shop.mtcoding.bank.repository.users.UsersRepository;

import java.time.LocalDateTime;

public class DummyData {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SystemErrorsRepository systemErrorsRepository;

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

    protected void errorMessageSetting() {
        systemErrorsRepository.save(SystemErrors.builder()
                .code("500-001")
                .message("이미 가입된 유저입니다.")
                .build());
        systemErrorsRepository.save(SystemErrors.builder()
                .code("500-002")
                .message("회원가입 유효성 검사 오류.")
                .build());
    }

    protected void userSetting() {
        usersRepository.save(newUser("asdf2"));
    }
}
