package study;

import baseball.Application;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
