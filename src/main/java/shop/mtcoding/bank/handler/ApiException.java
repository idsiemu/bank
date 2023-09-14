package shop.mtcoding.bank.handler;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ApiException extends RuntimeException {
    private final String code;
    private Map<String, String> data = new HashMap<>();
    public ApiException(String code) {
        this.code = code;
    }

    public ApiException(String code, Map<String, String> data) {
        this.code = code;
        this.data = data;
    }
}
