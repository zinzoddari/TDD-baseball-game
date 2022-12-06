package enums;

public enum BallStatus {
    BALL, STRIKE, NOTING;

    public boolean isNotNoting() {
        return this != NOTING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
