package baseball.game;

import baseball.domain.Computer;
import baseball.dto.GameResult;
import baseball.generator.GameResultMessageGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    private final Computer baseballComputer = new Computer();

    public void startGame() {
        OutputView.printGameStart();
        do {
            baseballComputer.generateNumber(RandomNumberGenerator::generateRandomNumbers);
            startUserTurn();
            OutputView.printGameOver();
        } while (askRestart() == GameCommand.RESTART);
    }

    private void startUserTurn() {
        GameResult gameResult;
        do {
            baseballComputer.addUserNumber(InputView.inputUserNumber());
            gameResult = baseballComputer.createResult();
            OutputView.printGameResult(GameResultMessageGenerator.createGameResultMessage(gameResult));
        } while (!gameResult.isWin());
    }

    private GameCommand askRestart() {
        String userSelection = InputView.inputRestart();
        return GameCommand.findCommand(userSelection);
    }
}
