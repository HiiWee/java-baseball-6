package baseball.game;

import java.util.Map;
import java.util.Optional;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private final String commandValue;
    private static final Map<String, GameCommand> gameCommands;

    static {
        gameCommands = Map.of(RESTART.commandValue, RESTART, QUIT.commandValue, QUIT);
    }

    GameCommand(final String commandValue) {
        this.commandValue = commandValue;
    }

    public static GameCommand findCommand(final String userSelection) {
        return Optional.ofNullable(gameCommands.get(userSelection))
                .orElseThrow(() -> new IllegalArgumentException("1(재시작) 혹은 2(종료)만 입력해야 합니다."));
    }
}
