package study;

import dto.Ball;
import dto.Balls;
import enums.BallStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    @Test
    void strike() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(1, 1));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(1, 2));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void noting() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(1, 4));

        assertThat(status).isEqualTo(BallStatus.NOTING);
    }
}
