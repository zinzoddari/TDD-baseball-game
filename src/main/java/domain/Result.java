package domain;

import enums.BallResult;

public class Result {
    private int strike = 0;
    private int ball = 0;

    public void report(BallResult ballResult) {
        if(ballResult.isStrike()) strike++;
        if(ballResult.isBall()) ball++;
    }

    public void result() {
        StringBuilder sb = new StringBuilder();
        if(strike > 0) sb.append(strike+"스트라이크 ");
        if(ball > 0) sb.append(ball+"볼");
        System.out.println(sb.toString().trim());
    }
}
