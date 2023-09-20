package shop.mtcoding.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.function.ServerResponse;
import shop.mtcoding.bank.dto.users.SignUpRequestDto;
import shop.mtcoding.bank.dummy.DummyData;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class UsersControllerTest extends DummyData {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper om;

    @BeforeEach
    public void setUp() {
        errorMessageSetting();
        userSetting();
    }

    @Test
    public void joinSuccessTest() throws Exception {
        //given
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setEmail("asdf@gmail.com");
        requestDto.setFullname("asdf");
        requestDto.setPassword("asdfasdf");
        requestDto.setUsername("asdf");

        String requestBody = om.writeValueAsString(requestDto);
        System.out.println(requestBody);

        //when
        ResultActions resultActions = mvc.perform(post("/api/signup").content(requestBody).contentType(MediaType.APPLICATION_JSON));
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        //then
        resultActions.andExpect(status().isOk());

    }

    @Test
    public void joinFailTest() throws Exception {
        //given
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setEmail("asdf2@gmail.com");
        requestDto.setFullname("asdf");
        requestDto.setPassword("asdfasdf2");
        requestDto.setUsername("asdf2");

        String requestBody = om.writeValueAsString(requestDto);
        System.out.println(requestBody);

        //when
        ResultActions resultActions = mvc.perform(post("/api/signup").content(requestBody).contentType(MediaType.APPLICATION_JSON));
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);

        //then
        resultActions.andExpect(status().isBadRequest());
    }

}