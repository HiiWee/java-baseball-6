package baseball.domain;

public enum GameNumberCondition {

    NUMBER_LENGTH(3);

    private final int value;

    GameNumberCondition(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
