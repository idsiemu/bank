package shop.mtcoding.bank.handler;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private final String code;
    public ApiException(String code) {
        this.code = code;
    }
}
