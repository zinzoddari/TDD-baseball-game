package study;

import enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    private Balls answers;
    private PlayResult result;

    @BeforeEach
    void init() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_noting() {
        result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void plat_1strike_1ball() {
        result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isNotEqualTo(0);
        assertThat(result.getBall()).isNotEqualTo(0);
    }

    @Test
    void plat_3strike() {
        result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isEqualTo(true);
    }

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
