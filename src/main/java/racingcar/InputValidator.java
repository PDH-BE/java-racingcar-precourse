package racingcar;

public class InputValidator {
    private static final int LIMIT_OF_NAME_LENGTH = 5;

    public void validateNamesWithComma(String namesWithComma) throws IllegalArgumentException {
        if (namesWithComma.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 이름이 ,로 끝나서는 안됩니다.");
        }
        String[] names = namesWithComma.split(",");
        for (String name : names) {
            validateName(name);
        }
    }

    public void validateRoundString(String roundString) throws IllegalArgumentException {
        if (!roundString.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 횟수는 1 이상의 정수여야 합니다.");
        }
        int round = Integer.parseInt(roundString);
        if (round == 0) {
            throw new IllegalArgumentException("[ERROR] 횟수가 0 이여서는 안됩니다.");
        }
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름이 공백이여선 안됩니다.");
        }
        if (name.length() > LIMIT_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다.");
        }
    }
}
