package enums;

public enum Game {
    PLAY("1"),
    AGAIN("2");

    String number;

    Game(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public static boolean isReplay(String number) {
        return number == Game.AGAIN.getNumber();
    }
}
