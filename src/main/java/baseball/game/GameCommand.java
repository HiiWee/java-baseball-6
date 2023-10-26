package baseball.game;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private final String commandValue;
    private static final Map<String, GameCommand> GAME_COMMANDS;

    static {
        GAME_COMMANDS = Arrays.stream(GameCommand.values())
                .collect(Collectors.toMap(gameCommand -> gameCommand.commandValue, gameCommand -> gameCommand));
    }

    GameCommand(final String commandValue) {
        this.commandValue = commandValue;
    }

    public static GameCommand findCommand(final String userSelection) {
        return Optional.ofNullable(GAME_COMMANDS.get(userSelection))
                .orElseThrow(() -> new IllegalArgumentException("1(재시작) 혹은 2(종료)만 입력해야 합니다."));
    }
}
