package shop.mtcoding.bank.config.jwt;


public interface JwtVo {
    public static final String secret = "bank!23";
    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 2; // 2시간
    public static final String TOKEN_NAME = "bank_token";
    public static final String REFRESH_TOKEN = "refresh_token";
}
