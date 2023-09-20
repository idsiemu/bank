package shop.mtcoding.bank.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.mtcoding.bank.config.auth.UserSession;
import shop.mtcoding.bank.domain.users.UserEnum;
import shop.mtcoding.bank.domain.users.Users;

import java.util.Date;

public class JwtProcess {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // 토큰 생성
    public static String create(UserSession userSession) {
        String jwtToken = JWT.create()
                .withSubject("bank")
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtVo.EXPIRATION_TIME))
                .withClaim("id", userSession.getUser().getId())
                .withClaim("role", userSession.getUser().getRole().name())
                .sign(Algorithm.HMAC512(JwtVo.secret));
        return jwtToken;
    }

    // 토큰 검증
    public static UserSession verify(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(JwtVo.secret)).build().verify(token);
        Long id = decodedJWT.getClaim("id").asLong();
        String role = decodedJWT.getClaim("role").asString();
        Users user = Users.builder().id(id).role(UserEnum.valueOf(role)).build();
        UserSession userSession = new UserSession(user);
        return userSession;
    }
}
