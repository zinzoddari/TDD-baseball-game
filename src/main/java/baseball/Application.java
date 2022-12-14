package baseball;

import domain.Balls;
import domain.Result;
import nextstep.utils.Console;

public class Application {
    private static Result result;
    private static Balls computer;

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        playStart();

        while (!result.isGameEnd()) {
            System.out.print("숫자를 입력해주세요:");
            result = computer.play(new Balls(Console.readLine()));
            result.result();

            if(result.isGameEnd()) {
                System.out.println("게임을 새로 시작하려면 1,종료하려면 2를입력하세요.");
                if (Console.readLine().equals("1")) {
                    playStart();
                }
            }
        }
    }

    public static void playStart() {
        result = new Result();
        computer = new Balls();
    }
}
