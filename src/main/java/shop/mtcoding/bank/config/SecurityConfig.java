package shop.mtcoding.bank.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import shop.mtcoding.bank.domain.users.UserEnum;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        logger.debug("디버그 : BCryptPasswordEncoder 빈등록됨");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.headers().frameOptions().disable(); // iframe 허용 안함
        http.csrf().disable(); // enable 이면 postman 안됨
        http.cors().configurationSource(configurationSource());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // SessionId를 서버에서 관리 안하겠다.
        http.formLogin().disable(); // 로그인 폼 막음
        http.httpBasic().disable(); // 팝업창으로 인정처리되는 기능 막음
        http.authorizeHttpRequests()
                .antMatchers("/api/auth/**").authenticated()
                .antMatchers("/api/admin/**").hasRole(UserEnum.ADMIN.getValue())
                .anyRequest().permitAll();
        return http.build();
    }

    public CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*"); // All restful method type 허용
        configuration.addAllowedOriginPattern("*"); // 모든 IP 주소 허용
        configuration.setAllowCredentials(true); // 클라이언트 쿠키 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
