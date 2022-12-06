package dto;

import enums.BallStatus;

public class Ball {
    private final int index;
    private final int num;

    public Ball(int index, int num) {
        this.index = index;
        this.num = num;
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball))       return BallStatus.STRIKE;
        if(ball.matchBallNum(num))  return BallStatus.BALL;
        return BallStatus.NOTING;
    }

    private boolean matchBallNum(int num) {
        return this.num == num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && num == ball.num;
    }
}
