package dto;

import enums.BallStatus;

import java.util.ArrayList;
import java.util.List;

public class Balls {
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

    public BallStatus play(Ball input) {
        return balls.stream()
                .map(answer -> answer.play(input))
                .filter(BallStatus::isNotNoting)
                .findFirst()
                .orElse(BallStatus.NOTING);
    }
}
