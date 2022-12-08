package study;

import baseball.Application;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;
import utils.ValidationUtils;

import static org.assertj.core.api.Assertions.*;

public class StringTest extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 입력값_split으로_분리() {
        assertThat(StringUtils.stringSplit("1,2", ",")).contains("1");
    }

    @Test
    void removeBracket() {
        String input = "(1,2)";

        if(input.indexOf('(') > -1) input = input.substring(input.indexOf('(') + 1, input.length());
        if(input.indexOf(')') > -1) input = input.substring(0, input.indexOf(')'));

        assertThat(input).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기(IndexOutOfException)")
    void get_char_index_out_of_exception() {
        String input = "abc";
        int index = 10;

        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: %d", index);
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void get_char_index() {
        String input = "abc";
        int index = 2;

        assertThat(input.charAt(index)).isEqualTo('c');
    }

    @Test
    @DisplayName("야구 숫자 1-9 유효성 검사")
    void validNum() {
        //1-9까지 때문에 확인
        assertThat(ValidationUtils.isNum(9)).isTrue();
        assertThat(ValidationUtils.isNum(1)).isTrue();
        //경계 값으로 실패 코드 -> 프로덕션 코드 재작성
        assertThat(ValidationUtils.isNum(0)).isFalse();
        assertThat(ValidationUtils.isNum(10)).isFalse();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
