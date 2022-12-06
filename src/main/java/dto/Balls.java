package dto;

import baseball.Playable;
import enums.BallStatus;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable {
    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> input) {
        Balls userBalls = new Balls(input);
        PlayResult result = new PlayResult();
        for (Ball answer : balls) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball input) {
        return balls.stream()
                .map(answer -> answer.play(input))
                .filter(BallStatus::isNotNoting)
                .findFirst()
                .orElse(BallStatus.NOTING);
    }
}
