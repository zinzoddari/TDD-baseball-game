package enums;

public enum Game {
    PLAY("1"),
    END("2");

    String number;

    Game(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    
    public Game getGame(String number) {
        for (Game game : Game.values()) {
            return game;
        }

        return Game.END;
    }

    public static boolean isReplay(String number) {
        return number.equals(Game.PLAY.getNumber());
    }
}
