package shop.mtcoding.bank.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shop.mtcoding.bank.domain.users.Users;
import shop.mtcoding.bank.handler.ApiException;
import shop.mtcoding.bank.repository.users.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserSessionService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userPS = usersRepository.findByUsername(username).orElseThrow(() -> new InternalAuthenticationServiceException("인증 실패"));
        return new UserSession(userPS);
    }
}
