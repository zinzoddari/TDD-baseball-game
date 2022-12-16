package domain;

import enums.BallResult;
import nextstep.utils.Randoms;

public class Ball {
    public static final int LIMIT_MIN_BALL_NUMBER = 1;
    public static final int LIMIT_MAX_BALL_NUMBER = 9;
    public static final int LIMIT_MIN_BALL_INDEX = 1;
    public static final int LIMIT_MAX_BALL_INDEX = 3;
    private int number;
    private int index;

    public Ball(int number, int index) {
        this.number = validateNumber(number);
        this.index = validateIndex(index);
    }

    public int validateNumber(int number) {
        if(number >= LIMIT_MIN_BALL_NUMBER && LIMIT_MAX_BALL_NUMBER >= number) return number;
        throw new IllegalArgumentException("볼 숫자는 " + LIMIT_MIN_BALL_NUMBER + "부터 " + LIMIT_MAX_BALL_NUMBER + " 의 값이어야한다.");
    }

    public int validateIndex(int index) {
        if(index >= LIMIT_MIN_BALL_INDEX && LIMIT_MAX_BALL_INDEX >= index) return index;
        throw new IllegalArgumentException("자릿수는 " + LIMIT_MIN_BALL_INDEX + "부터 " + LIMIT_MAX_BALL_INDEX  + "의 값이어야한다.");
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
