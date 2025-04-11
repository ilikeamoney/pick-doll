package pick_doll;

public enum GameStatus {
    GAME_OVER(User.getInstance().getRepo()[0].length - 1), START(1), SPACE(0);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
