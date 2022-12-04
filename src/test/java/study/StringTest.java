package study;

import baseball.Application;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ValidationUtils;

import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.*;

public class StringTest extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void StringSplit() {
        try {
            StringTokenizer st = new StringTokenizer("1,", ",");
            int array[] = new int[st.countTokens()];
            int index = 0;
            while (st.hasMoreTokens()) {
                array[index++] = Integer.parseInt(st.nextToken());
            }

          assertThat(array).contains(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
