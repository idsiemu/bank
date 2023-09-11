package shop.mtcoding.bank.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import shop.mtcoding.bank.dto.ErrorResponseDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    public static void errorException(HttpServletResponse response, Integer status, ErrorResponseDto responseDto) throws IOException {
        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(status);
        response.getWriter().println(om.writeValueAsString(responseDto));
    }
}
