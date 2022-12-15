package domain;

import enums.BallResult;

public class Result {
    private int strike = 0;
    private int ball = 0;

    public void report(BallResult ballResult) {
        if (ballResult.isStrike()) {
            strike++;
        }
        if (ballResult.isBall()) {
            ball++;
        }

    }

    public void result() {
        StringBuilder sb = new StringBuilder();

        if (strike > 0) {
            sb.append(strike + "스트라이크 ");
        }
        if (ball > 0) {
            sb.append(ball + "볼");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString().trim());

        if (isGameEnd()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}
