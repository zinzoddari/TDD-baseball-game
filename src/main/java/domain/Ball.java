package domain;

import enums.BallResult;

import java.util.Objects;

public class Ball {
    private int number;
    private int index;

    public Ball(int number, int index) {
        number = validateNumber(number);
        index = validateIndex(index);
    }

    public int validateNumber(int number) {
        if(number > 0 && 10 > number) return number;
        else throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야한다.");
    }

    public int validateIndex(int index) {
        if(index > 0 && 4 > index) return index;
        else throw new IllegalArgumentException("자릿수는 1부터 3의 값이어야한다.");
    }

    public BallResult result(Ball input) {
        if(this.equals(input))               return BallResult.STRIKE;
        else if(this.number == input.number) return BallResult.BALL;
        return BallResult.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && index == ball.index;
    }
}
