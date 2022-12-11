package enums;

public enum BallResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String result;

    BallResult(String result) {
        this.result = result;
    }
}
