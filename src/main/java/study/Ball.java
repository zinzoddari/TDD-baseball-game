package study;

import enums.BallStatus;
import java.util.Objects;

public class Ball {
    private final int index;
    private final BallNumber num;

    public Ball(int index, int num) {
        this.index = index;
        this.num = new BallNumber(num);
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball))       return BallStatus.STRIKE;
        if(ball.matchBallNum(num))  return BallStatus.BALL;
        return BallStatus.NOTING;
    }

    private boolean matchBallNum(BallNumber num) {
        return Objects.equals(this.num, num);
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
        return index == ball.index && Objects.equals(num, ball.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, num);
    }
}
