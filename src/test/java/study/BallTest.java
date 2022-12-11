package study;

import enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball computer;

    @BeforeEach
    void init() {
        computer = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallStatus status = computer.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = computer.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void noting() {
        BallStatus status = computer.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTING);
    }
}
