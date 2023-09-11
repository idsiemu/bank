package shop.mtcoding.bank.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDto<T> {
    // 응답이라 수정할일 없어 final로 선언함
    private final String code;
    private final String msg;
    private final T data;
}
