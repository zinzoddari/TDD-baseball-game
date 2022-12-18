package domain;

import enums.BallResult;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int MAX_BALL_SIZE = 3;
    private List<Ball> ballList;

    public Balls(String strBall) {
        if(!validateInput(strBall)) return;

        this.ballList = setBallList(strBall);
    }

    public Balls(List<Ball> createBallList) {
        this.ballList = createBallList;
    }

    public boolean validateInput(String str) {
        if(str.length() == MAX_BALL_SIZE) return true;
        throw new IllegalArgumentException("볼은 세개가 입력되어야 합니다.");
    }

    public List<Ball> setBallList(String str) {
        List<Ball> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Ball ball = new Ball(Integer.parseInt(str.substring(i, i + 1)), i + 1);
            list.add(ball);
        }

        return list;
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

    public static Balls createBalls() {
        List<Ball> createBallList = new ArrayList<>();

        while (MAX_BALL_SIZE > createBallList.size()) {
            Ball ball = Ball.createBall(createBallList.size() + 1);

            if(!createBallList.contains(ball)) {
                createBallList.add(ball);
            }
        }

        return new Balls(createBallList);
    }


}
