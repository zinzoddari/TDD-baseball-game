package domain;

import enums.BallResult;
import view.Print;

public class Result {
    public static final int STRIKE_VALUE = 3;
    private int strike = 0;
    private int ball = 0;

    public void report(BallResult ballResult) {
        if(ballResult.isStrike()) strike++;
        if(ballResult.isBall()) ball++;
    }

    public void result() {
        Print.printResult(strike, ball);

        if(isGameEnd()) Print.printGameEnd();
    }

    public boolean isGameEnd() {
        return strike == STRIKE_VALUE;
    }
}
