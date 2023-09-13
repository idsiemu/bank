package shop.mtcoding.bank.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.bank.dto.ErrorResponseDto;
import shop.mtcoding.bank.repository.system.SystemErrorsRepository;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalException {

    private final SystemErrorsRepository systemErrorsRepository;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> apiException(ApiException apiException) {
        ErrorResponseDto systemErrorDto = new ErrorResponseDto();
        systemErrorsRepository.findById(apiException.getCode())
                .ifPresent(error -> {
                    systemErrorDto.setCode(error.getCode());
                    systemErrorDto.setMessage(error.getMessage());
                });
        return new ResponseEntity<>(systemErrorDto, HttpStatus.BAD_REQUEST);
    }
}
