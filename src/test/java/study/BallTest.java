package study;

import dto.Ball;
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
        //all computer = new Ball(1, 4);        중복되는 코드는 @BeforeEach로 빼준다
        BallStatus status = computer.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void noting() {
        //Ball computer = new Ball(1, 4);
        BallStatus status = computer.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTING);
    }
}
