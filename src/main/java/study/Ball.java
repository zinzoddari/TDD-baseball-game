package study;

import enums.BallStatus;

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
        return this.num.equals(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && num.equals(ball.num);
    }
}
