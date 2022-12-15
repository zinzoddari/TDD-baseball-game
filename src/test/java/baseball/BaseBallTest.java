package baseball;

import domain.Ball;
import domain.Balls;
import enums.BallResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BaseBallTest {
    private Ball computer;
    private Balls comBalls;

    @BeforeEach
    void 초기화() {
        computer = new Ball(1, 1);
        comBalls = new Balls("156");
    }

    @Test
    void number_잘못된_숫자_입력하면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(10, 1));

    }

    @Test
    void index_잘못된_자릿수_입력() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(3, 4));
    }

    @Test
    void 낫씽_실패() {
        assertThat(computer.result(new Ball(1, 1))).isNotEqualTo(BallResult.NOTHING);
    }

    @Test
    void 낫씽_성공() {
        assertThat(computer.result(new Ball(3, 2))).isEqualTo(BallResult.NOTHING);
    }

    @Test
    void 볼_실패() {
        assertThat(computer.result(new Ball(2, 1))).isNotEqualTo(BallResult.BALL);
    }

    @Test
    void 볼_성공() {
        assertThat(computer.result(new Ball(1, 3))).isEqualTo(BallResult.BALL);
    }

    @Test
    void 스트라이크_실패() {
        assertThat(computer.result(new Ball(1, 3))).isNotEqualTo(BallResult.STRIKE);
    }

    @Test
    void 스트라이크_성공() {
        assertThat(computer.result(new Ball(1, 1))).isEqualTo(BallResult.STRIKE);
    }

    @Test
    void 볼갯수_입력_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls("13"));
    }

    @Test
    void 볼갯수_입력_성공() {
        Balls balls = new Balls("132");
    }

    @Test
    void 스트라이크_1() {
        Balls balls = new Balls("132");
        comBalls.play(balls);
    }

    @Test
    void 스트라이크_2() {
        Balls balls = new Balls("152");
        comBalls.play(balls);
    }

    @Test
    void 스트라이크_3() {
        Balls balls = new Balls("156");
        comBalls.play(balls);
    }

    @Test
    void 볼_1() {
        Balls balls = new Balls("231");
        comBalls.play(balls);
    }

    @Test
    void 볼_2() {
        Balls balls = new Balls("531");
        comBalls.play(balls);
    }

    @Test
    void 낫싱() {
        Balls balls = new Balls("127");
        comBalls.play(balls).result();
    }

    @Test
    void ball_생성() {
        Balls balls = Balls.createBalls();
    }
}
