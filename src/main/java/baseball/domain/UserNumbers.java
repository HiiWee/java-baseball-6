package baseball.domain;

import baseball.validator.UserNumberValidator;
import java.util.Arrays;
import java.util.List;

public class UserNumbers extends Numbers {

    private UserNumbers(final List<Integer> numbers) {
        super(numbers);
    }

    public static UserNumbers createUserNumbers(final String userInput) {
        UserNumberValidator.validate(userInput);
        List<Integer> userNumbers = mapToIntegers(userInput);
        return new UserNumbers(userNumbers);
    }

    private static List<Integer> mapToIntegers(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
