package domain;

import enums.BallResult;
import java.util.Objects;
import nextstep.utils.Randoms;
import study.BallNumber;

public class Ball {
    private BallNumber number;
    private BallIndex index;

    public Ball(int number, int index) {
        this.number = new BallNumber(number);
        this.index = new BallIndex(index);
    }

    public BallResult result(Ball input) {
        if (Objects.equals(this, input)) {
            return BallResult.STRIKE;
        }

        if (Objects.equals(number, input.number)) {
            return BallResult.BALL;
        }

        return BallResult.NOTHING;
    }

    public static Ball createBall(int index) {
        return new Ball(Randoms.pickNumberInRange(BallNumber.MIN_NUM, BallNumber.MAX_NUM), index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number) && Objects.equals(index, ball.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, index);
    }
}
