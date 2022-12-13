package baseball;

import domain.Balls;
import domain.Result;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    private static Result result;
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        result = new Result();
        Balls computer = new Balls("" + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9));
        while (!result.isGameEnd()) {
            result = computer.play(new Balls(Console.readLine()));
            result.result();

            if(result.isGameEnd()) {
                System.out.println("게임 끝");
                if (Console.readLine().equals("1")) {
                    result = new Result();
                    computer = new Balls("" + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9));
                }
            }
        }
    }
}
