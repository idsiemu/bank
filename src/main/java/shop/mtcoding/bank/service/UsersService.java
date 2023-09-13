package shop.mtcoding.bank.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.bank.domain.users.Users;
import shop.mtcoding.bank.dto.users.SignUpResponseDto;
import shop.mtcoding.bank.handler.ApiException;
import shop.mtcoding.bank.repository.users.UsersRepository;
import shop.mtcoding.bank.dto.users.SignUpRequestDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final UsersRepository usersRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
        Optional<Users> user = usersRepository.findByUsername(requestDto.getUsername());
        if(user.isPresent()) {
            throw new ApiException("500-001");
        }

        Users userPS = usersRepository.save(requestDto.toEntity(passwordEncoder));

        return new SignUpResponseDto(userPS);
    }
}
