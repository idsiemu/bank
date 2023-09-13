package shop.mtcoding.bank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.bank.dto.users.SignUpRequestDto;
import shop.mtcoding.bank.dto.users.SignUpResponseDto;
import shop.mtcoding.bank.handler.ApiException;
import shop.mtcoding.bank.service.UsersService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ApiException("500-002");
        }
        SignUpResponseDto responseDto = usersService.signUp(signUpRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
