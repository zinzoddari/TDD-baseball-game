package enums;

public enum BallStatus {
    BALL, STRIKE, NOTING;

    public boolean isNotNoting() {
        return this != NOTING;
    }
}
