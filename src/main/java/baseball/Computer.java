package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int COUNT_TO_GENERATE = 3;

    private Numbers computerNumbers;
    private Numbers userNumbers;

    public void generateNumber() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(COUNT_TO_GENERATE);
        computerNumbers = Numbers.from(randomNumbers);
    }

    public void addUserNumber(final String inputUserNumber) {
        this.userNumbers = convertToNumbers(inputUserNumber);
    }

    private Numbers convertToNumbers(final String inputUserNumber) {
        validate(inputUserNumber);
        List<Integer> userNumbers = Arrays.stream(inputUserNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Numbers.from(userNumbers);
    }

    private void validate(final String inputUserNumber) {
        validateLength(inputUserNumber);
        validateInteger(inputUserNumber);
        validateRandomNumber(inputUserNumber);
    }

    private static void validateInteger(final String inputUserNumber) {
        try {
            Integer.parseInt(inputUserNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private static void validateLength(final String inputUserNumber) {
        if (inputUserNumber.length() != COUNT_TO_GENERATE) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateRandomNumber(final String inputUserNumber) {
        String[] userNumbers = inputUserNumber.split("");
        if (userNumbers[0].equals(userNumbers[1])
                || userNumbers[1].equals(userNumbers[2])
                || userNumbers[0].equals(userNumbers[2])) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
