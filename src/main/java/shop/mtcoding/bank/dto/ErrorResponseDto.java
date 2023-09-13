package shop.mtcoding.bank.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto<T> {
    // 응답이라 수정할일 없어 final로 선언함
    private String code = "000";
    private String message = "";
    private T data;

}
