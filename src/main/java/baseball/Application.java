package baseball;

import domain.Balls;
import domain.Result;
import enums.Game;
import nextstep.utils.Console;

public class Application {
    private static Result result;
    private static Balls computer;

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        playStart(Game.PLAY.getNumber());

        while (!result.isGameEnd()) {
            System.out.print("숫자를 입력해주세요:");

            baseballPlay(Console.readLine());

            if(result.isGameEnd()) playStart(Console.readLine());
        }
    }

    private static void baseballPlay(String answer) {
        result = computer.play(new Balls(answer));
        result.result();
    }

    public static void playStart(String answer) {
        if(result != null && result.isGameEnd()) System.out.println("게임을 새로 시작하려면 1,종료하려면 2를입력하세요.");

        if(Game.isReplay(answer)) {
            result = new Result();
            computer = Balls.createBalls();
        }
    }
}
