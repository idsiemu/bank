package shop.mtcoding.bank.temp;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RegexTest {

    @Test
    public void hanTest() throws Exception{
        String value = "ㅁㄴㅇㄹ";
        boolean result = Pattern.matches("^[ㄱ-ㅎ가-힣]+$", value);
        System.out.println(result);
        assertThat(result).isTrue();
    }

    @Test
    public void noHanTest() throws Exception{
        String value = "1233";
        boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힣]*$", value);
        System.out.println(result);
        assertThat(result).isTrue();
    }

    @Test
    public void enTest() throws Exception{
        String value = "asdf";
        boolean result = Pattern.matches("^[a-zA-Z]*$", value);
        System.out.println(result);
        assertThat(result).isTrue();
    }

    @Test
    public void enOrNumTest() throws Exception{
        String value = "asdf";
        boolean result = Pattern.matches("^[a-zA-Z0-9]+$", value);
        System.out.println(result);
        assertThat(result).isTrue();
    }

    @Test
    public void enOrNumWithLengthTest() throws Exception{
        String value = "asdf12asdf3";
        boolean result = Pattern.matches("^[a-zA-Z0-9]{8,20}$", value);
        System.out.println(result);
        assertThat(result).isTrue();
    }
}
