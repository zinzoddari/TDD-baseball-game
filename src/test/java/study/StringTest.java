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
    void 입력값_괄호_삭제() {
        String input = "(1,2)";

        input = StringUtils.removeFromChar(input, '(');
        input = StringUtils.removeToChar(input, ')');

        assertThat(input).isEqualTo("1,2");
    }

    @Test
    void 특정_위치_문자_가져오기_IndexOutOfException() {
        String input = "abc";
        int index = 10;

        assertThatThrownBy(() -> StringUtils.getCharByIndex(input, index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: %d", index);
    }

    @Test
    void 특정_위치_문자_가져오기() {
        String input = "abc";
        int index = 2;

        assertThat(StringUtils.getCharByIndex(input, index)).isEqualTo('c');
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
