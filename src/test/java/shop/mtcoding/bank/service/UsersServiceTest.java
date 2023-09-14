package shop.mtcoding.bank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.bank.domain.users.Users;
import shop.mtcoding.bank.dto.users.SignUpRequestDto;
import shop.mtcoding.bank.dto.users.SignUpResponseDto;
import shop.mtcoding.bank.dummy.DummyData;
import shop.mtcoding.bank.repository.users.UsersRepository;
import shop.mtcoding.bank.service.UsersService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest extends DummyData {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    @Spy
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void signUpTest() throws Exception {
        // given
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setEmail("asdf@gmail.com");
        requestDto.setFullname("asdf");
        requestDto.setPassword("asdf");
        requestDto.setUsername("asdf");

        // stub 1
        when(usersRepository.findByUsername(any())).thenReturn(Optional.empty());
//        when(usersRepository.findByUsername(any())).thenReturn(Optional.of(new Users()));

        // stub 2
        Users user = newMockUser(1l, "asdf");
        when(usersRepository.save(any())).thenReturn(user);

        // when
        SignUpResponseDto signUpResponseDto = usersService.signUp(requestDto);
        System.out.println(signUpResponseDto);

        // then
        assertThat(signUpResponseDto.getId()).isEqualTo(1l);
        assertThat(signUpResponseDto.getFullname()).isEqualTo("asdf");

    }
}