package baseball.generator;

import baseball.domain.GameNumberCondition;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    private static final int STARTING_RANGE = GameNumberCondition.STARTING_RANGE.getValue();
    private static final int END_RANGE = GameNumberCondition.END_RANGE.getValue();

    private RandomNumberGenerator() {
    }

    public static List<Integer> generateRandomNumbers(final int countToGenerate) {
        return Stream.generate(() -> Randoms.pickNumberInRange(STARTING_RANGE, END_RANGE))
                .distinct()
                .limit(countToGenerate)
                .toList();
    }
}
