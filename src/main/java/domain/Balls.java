package domain;

import enums.BallResult;

import java.util.ArrayList;
import java.util.List;
import study.BallNumber;

public class Balls {
    private List<Ball> ballList;

    public Balls(String strBall) {
        if (!isEqualBallSize(strBall)) {
            return;
        }
        this.ballList = setBallList(strBall);
    }
    private List<Ball> setBallList(String str) {
        List<Ball> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Ball ball = new Ball(Integer.parseInt(str.substring(i, i + 1)), i + 1);
            list.add(ball);
        }

        return list;
    }
    public static Balls createBalls() {
        List<Ball> createBallList = new ArrayList<>();

        while (BallIndex.MAX_INDEX > createBallList.size()) {
            Ball ball = Ball.createBall(createBallList.size() + 1);

            if (!createBallList.contains(ball)) {
                createBallList.add(ball);
            }
        }

        return new Balls(createBallList);
    }

    public Balls(List<Ball> createBallList) {
        this.ballList = createBallList;
    }

    public boolean isEqualBallSize(String str) {
        if (str.length() == BallIndex.MAX_INDEX) {
            return true;
        }
        throw new IllegalArgumentException("볼은" + BallIndex.MAX_INDEX + "개 가 입력되어야 합니다.");
    }

    public Result play(Balls input) {
        Result result = new Result();
        for (Ball ball : input.ballList) {
            result.report(play(ball));
        }
        return result;
    }

    public BallResult play(Ball input) {
        return ballList.stream()
                .map(answer -> answer.result(input))
                .filter(BallResult::isNotNoting)
                .findFirst()
                .orElse(BallResult.NOTHING);
    }

}
