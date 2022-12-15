package study;

import java.util.Objects;

public class BallNumber {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private final int no;

    public BallNumber(int no) {
        if (no < MIN_NUM || no > MAX_NUM) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야한다.");
        }
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
