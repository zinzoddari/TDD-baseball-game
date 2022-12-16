package domain;

import enums.BallResult;

public class Print {
    public static void printPrintNumber() {
        System.out.println("숫자를 입력해주세요:");
    }

    public static void printReplay() {
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를입력하세요.");
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printResult(int strikeCnt, int ballCnt) {
        StringBuilder sb = new StringBuilder();

        if(strikeCnt > 0) sb.append(strikeCnt + BallResult.STRIKE.getResult() + " ");
        if(ballCnt > 0) sb.append(ballCnt + BallResult.BALL.getResult());
        if(sb.length() == 0) sb.append(BallResult.NOTHING.getResult());

        System.out.println(sb.toString().trim());
    }
}
