package domain;

import java.util.Objects;

public class BallIndex {
    private final int index;
    public final static int MIN_INDEX = 1;
    public final static int MAX_INDEX = 3;

    public BallIndex(int index) {
        validate(index);
        this.index = index;
    }

    private void validate(int index) {
        if(index < MIN_INDEX || index > MAX_INDEX) {
            throw new IllegalArgumentException("자릿수는 1부터 3의 값이어야한다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallIndex)) {
            return false;
        }
        BallIndex ballIndex = (BallIndex) o;
        return index == ballIndex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
