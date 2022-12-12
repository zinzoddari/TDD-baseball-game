package enums;

public enum BallResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String result;

    BallResult(String result) {
        this.result = result;
    }

    public boolean isNotNoting() {
        return this != NOTHING;
    }

    public boolean isNoting() {
        return this == NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public String getResult() {
        return this.result;
    }
}
