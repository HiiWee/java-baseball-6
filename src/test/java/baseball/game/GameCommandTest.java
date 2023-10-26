package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @DisplayName("재시작(1) 혹은 종료(2)만 입력할 수 있다.")
    @Test
    void findCommand() {
        // given & when
        GameCommand command1 = GameCommand.findCommand("1");
        GameCommand command2 = GameCommand.findCommand("2");

        // then
        assertAll(
                () -> assertThat(command1).isEqualTo(GameCommand.RESTART),
                () -> assertThat(command2).isEqualTo(GameCommand.QUIT)
        );
    }

    @DisplayName("재시작(1), 종료(2)가 아닌 다른 입력이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "0", " ", ""})
    void findCommand_exception_invalidUserSelect(String invalidUserSelect) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> GameCommand.findCommand(invalidUserSelect))
                .withMessageContaining("1(재시작) 혹은 2(종료)만 입력해야 합니다.");
    }
}