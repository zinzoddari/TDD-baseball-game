package domain;

import enums.BallResult;
import nextstep.utils.Randoms;

public class Ball {
    private int number;
    private int index;

    public Ball(int number, int index) {
        this.number = validateNumber(number);
        this.index = validateIndex(index);
    }

    public int validateNumber(int number) {
        if(number > 0 && 10 > number) return number;
        throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야한다.");
    }

    public int validateIndex(int index) {
        if(index > 0 && 4 > index) return index;
        throw new IllegalArgumentException("자릿수는 1부터 3의 값이어야한다.");
    }

    public BallResult result(Ball input) {
        if(this.number == input.number && this.index == input.index)               return BallResult.STRIKE;
        if(this.number == input.number) return BallResult.BALL;
        return BallResult.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    public static Ball createBall(int index) {
        return new Ball(Randoms.pickNumberInRange(1, 3), index);
    }
}
